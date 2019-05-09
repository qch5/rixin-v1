package com.rixin.wechat.bean.response.ai;

import com.rixin.wechat.bean.response.BaseResponse;

/**
 * 微信翻译接口返回.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class TranslateResponse extends BaseResponse {
    private String fromContent;
    private String toContent;

    public String getFromContent() {
        return fromContent;
    }

    public void setFromContent(String fromContent) {
        this.fromContent = fromContent;
    }

    public String getToContent() {
        return toContent;
    }

    public void setToContent(String toContent) {
        this.toContent = toContent;
    }

    @Override
    public String toString() {
        return "TranslateResponse{"
                + "errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + ", fromContent='" + fromContent + '\''
                + ", toContent='" + toContent + '\'' +
                '}';
    }
}
