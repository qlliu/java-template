package com.doublefs.common.javatemplate.service;

import com.doublefs.common.javatemplate.dao.FeedConfigDao;
import com.doublefs.common.javatemplate.dao.FeedConfigMapper;
import com.doublefs.common.javatemplate.model.FeedConfig;
import com.doublefs.common.javatemplate.vo.TestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author liuqingliang
 */
@Service
public class ExampleService {

    @Autowired
    FeedConfigDao feedConfigDao;

    @Autowired
    FeedConfigMapper feedConfigMapper;

    private final static Logger logger = LoggerFactory.getLogger(ExampleService.class);

    public TestResult test() {
        String txt = "insert";
        logger.info("[example] I'm info, {}", txt);
        logger.error("[example] I'm error, {}", txt);

        TestResult resp = new TestResult();
        resp.setFit(true);
        resp.setValue(txt.length());
        resp.setData(feedConfigDao.getTest());
//        resp.setData(feedConfigMapper.selectAll());

        return resp;
    }
}
