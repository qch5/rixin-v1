package com.rixin.wechat.bean.response.ai;

import com.rixin.wechat.bean.response.BaseResponse;

/**
 * 语音识别接口返回.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class VoiceToTextResponse extends BaseResponse {
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "VoiceToTextResponse{"
                + "errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + ", result='" + result + '\''
                + '}';
    }
}
