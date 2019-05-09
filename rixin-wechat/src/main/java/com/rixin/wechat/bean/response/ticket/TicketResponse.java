package com.rixin.wechat.bean.response.ticket;

import com.rixin.wechat.bean.response.BaseResponse;

/**
 * 微信JSAPI Ticket信息.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class TicketResponse extends BaseResponse {
    private String ticket;
    private Integer expiresIn;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    @Override
    public String toString() {
        return "TicketResponse{"
                + "ticket='" + ticket + '\''
                + ", expiresIn=" + expiresIn
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
