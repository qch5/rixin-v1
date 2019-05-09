package com.rixin.wechat.bean.response.ip;


import com.rixin.wechat.bean.response.BaseResponse;

import java.util.List;

/**
 * IP列表.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class IpListResponse extends BaseResponse {
    private List<String> ipList;

    public List<String> getIpList() {
        return ipList;
    }

    public void setIpList(List<String> ipList) {
        this.ipList = ipList;
    }

    @Override
    public String toString() {
        return "IpListResponse{"
                + "ipList=" + ipList
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
