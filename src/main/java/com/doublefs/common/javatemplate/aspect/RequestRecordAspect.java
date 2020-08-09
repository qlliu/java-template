package com.doublefs.common.javatemplate.aspect;

import com.doublefs.common.javatemplate.configs.Constant;
import com.doublefs.common.javatemplate.utils.HttpUtil;
import com.doublefs.common.javatemplate.utils.JacksonUtil;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liuqingliang
 */
@Aspect
@Component
public class RequestRecordAspect {
    private static final Integer IP_LENGTH = 15;
    private static final Integer ZERO = 0;
    private static final Integer MAX_LENGTH_RESPONSE = 500;
    private static final String IP_LOCALHOST_V6 = "0:0:0:0:0:0:0:1";
    private static final String IP_LOCALHOST = "127.0.0.1";
    private static final Logger logger = LoggerFactory.getLogger(RequestRecordAspect.class);

    /**
     * 匹配所有持有RestController 或者Controller注解类型内的方法
     */
    @Pointcut("@within(org.springframework.web.bind.annotation.RestController) || @within(org.springframework.stereotype.Controller)")
    public void init() {
    }

    @Around("init()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        String url = Constant.EMPTY_STR, param = Constant.EMPTY_STR, requestId = Constant.EMPTY_STR,
                method = Constant.EMPTY_STR, ipAddress = Constant.EMPTY_STR;

        if (sra != null) {
            HttpServletRequest request = sra.getRequest();
            url = request.getRequestURL().toString();
            param = request.getQueryString();
            method = request.getMethod();
            ipAddress = getIpAddress(request);
            requestId = request.getHeader(HttpUtil.HEADER_REQUEST_ID);
            // 获取post参数
            if(method != null && method.equalsIgnoreCase(HttpUtil.METHOD_POST) && pjp.getArgs()!= null && pjp.getArgs().length > 0) {
                param = pjp.getArgs()[0].toString();
            }
        }
        if (StringUtils.isEmpty(requestId)) {
            requestId = HttpUtil.generateRequestId();
        }
        // 写入链路request_id
        MDC.put(Constant.REQUEST_ID_KEY, requestId);
        if (sra == null) {
            logger.error("[RequestAttributes] decode failed.");
        }

        // 开始时间
        long startTime=System.currentTimeMillis();
        String startTimeStr=new SimpleDateFormat(Constant.FORMAT_TIME).format(startTime);
        List<Object> logArgs = Arrays.stream(pjp.getArgs())
                .filter(arg -> (!(arg instanceof HttpServletRequest) && !(arg instanceof HttpServletResponse)))
                .collect(Collectors.toList());
        logger.info("START===>request_url= {} {}{}，request_method={}，request_param={}，request_ip={}，begin_time={}",
                method, url, (param==null?"":"?"+param), ("{"+pjp.getTarget().getClass().getSimpleName() + "#"  +
                        pjp.getSignature().getName()+"}"), JacksonUtil.write(logArgs), ipAddress, startTimeStr);

        // 执行代码
        try {
            Object result = pjp.proceed();
            //结束时间
            long endTime=System.currentTimeMillis();
            String  endTimeStr=new SimpleDateFormat(Constant.FORMAT_TIME).format(endTime);
            //总共用时
            long consumeTime=endTime-startTime;
            String response = JacksonUtil.write(result);
            if (response != null && response.length() > MAX_LENGTH_RESPONSE) {
                response = response.substring(0,MAX_LENGTH_RESPONSE);
            }
            logger.info("END===>request_url= {} {}{}，request_method={}，consume_time={}ms，request_param={},response_result={}，request_ip={}，begin_time={}，end_time={}",
                    method, url, (param==null?"":"?"+param), ("{"+pjp.getTarget().getClass().getSimpleName() + "#"  +
                            pjp.getSignature().getName()+"}"), consumeTime, JacksonUtil.write(logArgs),
                    response, ipAddress, startTimeStr, endTimeStr);
            return result;
        } finally {
            MDC.remove(Constant.REQUEST_ID_KEY);
        }
    }


    private String getIpAddress(HttpServletRequest request) {
        String ipAddress = request.getRemoteAddr();
        if(IP_LOCALHOST.equals(ipAddress) || IP_LOCALHOST_V6.equals(ipAddress)){
            // 根据网卡获取本机配置的IP地址
            InetAddress inetAddress = null;
            try {
                inetAddress = InetAddress.getLocalHost();
            }
            catch (UnknownHostException e) {
                logger.info("get ip exception {}", e.getMessage());
            }
            assert inetAddress != null;
            ipAddress = inetAddress.getHostAddress();
        }
        // 对于通过多个代理的情况，第一个IP为客户端真实的IP地址，多个IP按照','分割
        if(null != ipAddress && ipAddress.length() > IP_LENGTH) {
            int ind = ipAddress.indexOf(",");
            if(ind > ZERO) {
                ipAddress = ipAddress.substring(ZERO, ind);
            }
        }
        return ipAddress;
    }

}
