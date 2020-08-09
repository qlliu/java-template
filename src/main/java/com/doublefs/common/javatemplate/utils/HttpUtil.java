package com.doublefs.common.javatemplate.utils;

import com.doublefs.common.javatemplate.configs.Constant;
import org.slf4j.MDC;

import java.util.UUID;

/**
 * @author liuqingliang
 */
public class HttpUtil {
    public static final String METHOD_GET = "GET";
    public static final String METHOD_POST = "POST";
    public static final String HEADER_REQUEST_ID = "X-Request-ID";
    public static final int CODE_OK = 0;
    public static final int CODE_ERROR_UNKNOWN = 500;
    public static final int CODE_ERROR_PARAM = -1;

    public static String getRequestId() {
        String requestId = MDC.get(Constant.REQUEST_ID_KEY);
        if (requestId == null) {
            requestId = generateRequestId();
        }
        return requestId;
    }

    public static String generateRequestId() {
        String requestId = UUID.randomUUID().toString();
        return requestId.replaceAll("-", "");
    }
}
