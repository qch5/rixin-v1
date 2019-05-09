package com.rixin.wechat.bean.response.media;


import com.rixin.wechat.bean.response.BaseResponse;

/**
 * 上传图文消息内的图片获取URL.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class UrlResponse extends BaseResponse {
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "UrlResponse{"
                + "url='" + url + '\''
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() +
                +'}';
    }
}
