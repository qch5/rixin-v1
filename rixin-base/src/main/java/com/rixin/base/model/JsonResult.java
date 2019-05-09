package com.rixin.base.model;

import com.rixin.base.page.PageMeta;

/**
 * User: dairan
 * Date: 2016-09-23 16:48
 */
public class JsonResult {
    private int ret;
    private Object json;
    private String message;
    private PageMeta page;

    public JsonResult() {
        super();
    }

    public JsonResult(int ret) {
        super();
        this.ret = ret;
        this.json = null;
        this.message = "";
    }

    public JsonResult(int ret, String message) {
        super();
        this.ret = ret;
        this.json = null;
        this.message = message;
    }

    public JsonResult(int ret, String message, Object json) {
        super();
        this.ret = ret;
        this.json = json;
        this.message = message;
    }

    public JsonResult(int ret, String message, Object json, PageMeta page) {
        super();
        this.ret = ret;
        this.json = json;
        this.message = message;
        this.page = page;
    }

    public int getRet() {
        return ret;
    }
    public void setRet(int ret) {
        this.ret = ret;
    }

    public Object getJson() {
        return json;
    }
    public void setJson(Object json) {
        this.json = json;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    
    public PageMeta getPage() {
        return page;
    }
}
