package com.doublefs.common.javatemplate.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuqingliang
 */
@Service
public class ExampleService {

    private final static Logger logger = LoggerFactory.getLogger(ExampleService.class);

    public List<String> test() {
        String txt = "insert";
        logger.info("[example] I'm info, {}", txt);
        logger.error("[example] I'm error, {}", txt);

        List<String> resp = new ArrayList<>();
        resp.add(txt);
        return resp;
    }
}
