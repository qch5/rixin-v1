package com.rixin.wechat.bean.response.message;


import com.rixin.wechat.bean.response.BaseResponse;

/**
 * 消息群发速度.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class MessageSendSpeedResponse extends BaseResponse {
    private String speed; //群发速度的级别
    private String realspeed; //群发速度的真实值 单位：万/分钟

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getRealspeed() {
        return realspeed;
    }

    public void setRealspeed(String realspeed) {
        this.realspeed = realspeed;
    }

    @Override
    public String toString() {
        return "MessageSendSpeedResponse{"
                + "speed='" + speed + '\''
                + ", realspeed='" + realspeed + '\''
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\'' +
                '}';
    }
}
