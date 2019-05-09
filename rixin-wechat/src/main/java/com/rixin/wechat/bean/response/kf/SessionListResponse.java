package com.rixin.wechat.bean.response.kf;

import com.rixin.wechat.bean.entity.kf.Session;
import com.rixin.wechat.bean.response.BaseResponse;

import java.util.List;

/**
 * 客服会话列表.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class SessionListResponse extends BaseResponse {
    private List<Session> sessionlist;

    public List<Session> getSessionlist() {
        return sessionlist;
    }

    public void setSessionlist(List<Session> sessionlist) {
        this.sessionlist = sessionlist;
    }

    @Override
    public String toString() {
        return "SessionListResponse{"
                + "sessionlist=" + sessionlist
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
