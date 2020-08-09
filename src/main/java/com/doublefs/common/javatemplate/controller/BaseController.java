package com.doublefs.common.javatemplate.controller;

import com.doublefs.common.javatemplate.utils.HttpUtil;
import com.doublefs.common.javatemplate.vo.JsonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuqingliang
 */
@RestController
public class BaseController {

    @RequestMapping(value = "/healthCheck", method = RequestMethod.GET)
    public JsonResult healthCheck() {
        JsonResult ret = new JsonResult();
        ret.setCode(HttpUtil.CODE_OK);
        return ret;
    }
}
