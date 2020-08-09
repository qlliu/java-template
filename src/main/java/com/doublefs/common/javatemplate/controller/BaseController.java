package com.doublefs.common.javatemplate.controller;

import com.doublefs.common.javatemplate.service.ExampleService;
import com.doublefs.common.javatemplate.utils.HttpUtil;
import com.doublefs.common.javatemplate.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuqingliang
 */
@RestController
public class BaseController {

    @Autowired
    ExampleService exampleService;

    @RequestMapping(value = "/healthCheck", method = RequestMethod.GET)
    public JsonResult healthCheck() {
        JsonResult ret = new JsonResult();
        ret.setCode(HttpUtil.CODE_OK);
        return ret;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public JsonResult test() {
        JsonResult ret = new JsonResult();
        ret.setCode(HttpUtil.CODE_OK);
        ret.setData(exampleService.test());
        return ret;
    }
}
