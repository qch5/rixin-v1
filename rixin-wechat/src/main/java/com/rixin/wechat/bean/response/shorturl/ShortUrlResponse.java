package com.rixin.wechat.bean.response.shorturl;

import com.rixin.wechat.bean.response.BaseResponse;

/**
 * 微信返回短连接Bean.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class ShortUrlResponse extends BaseResponse {
    private String shortUrl;

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    @Override
    public String toString() {
        return "ShortUrlResponse{"
                + "shortUrl='" + shortUrl + '\''
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
