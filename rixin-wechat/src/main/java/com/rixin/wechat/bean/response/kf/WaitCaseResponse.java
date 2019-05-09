package com.rixin.wechat.bean.response.kf;

import com.rixin.wechat.bean.entity.kf.WaitCase;
import com.rixin.wechat.bean.response.BaseResponse;

import java.util.List;

/**
 * 未接入会话接口返回信息.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class WaitCaseResponse extends BaseResponse {
    private Integer count; //未接入会话数量
    private List<WaitCase> waitcaselist; //未接入会话列表，最多返回100条数据，按照来访顺序

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<WaitCase> getWaitcaselist() {
        return waitcaselist;
    }

    public void setWaitcaselist(List<WaitCase> waitcaselist) {
        this.waitcaselist = waitcaselist;
    }

    @Override
    public String toString() {
        return "WaitCaseResponse{"
                + "count=" + count
                + ", waitcaselist=" + waitcaselist
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
