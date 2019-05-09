package com.rixin.wechat.bean.response.kf;

import com.rixin.wechat.bean.entity.kf.KfAccount;
import com.rixin.wechat.bean.response.BaseResponse;

import java.util.List;

/**
 * 客服账号列表.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class KfListResponse extends BaseResponse {
    private List<KfAccount> kfList;

    public List<KfAccount> getKfList() {
        return kfList;
    }

    public void setKfList(List<KfAccount> kfList) {
        this.kfList = kfList;
    }

    @Override
    public String toString() {
        return "KfListResponse{"
                + "kfList=" + kfList
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
