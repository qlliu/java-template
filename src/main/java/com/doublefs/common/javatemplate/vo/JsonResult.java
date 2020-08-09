package com.doublefs.common.javatemplate.vo;

import com.doublefs.common.javatemplate.utils.HttpUtil;

/**
 * @author liuqingliang
 */
public class JsonResult {
    private int code;
    private boolean isSuccess;
    private String message;
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
        this.isSuccess = code == HttpUtil.CODE_OK;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
