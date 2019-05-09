package com.rixin.wechat.bean.response.user;

import com.rixin.wechat.bean.response.BaseResponse;

import java.util.List;

/**
 * 标签ID列表.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class TagIdListResponse extends BaseResponse {
    private List<String> tagidList;

    public List<String> getTagidList() {
        return tagidList;
    }

    public void setTagidList(List<String> tagidList) {
        this.tagidList = tagidList;
    }

    @Override
    public String toString() {
        return "TagIdListResponse{"
                + "tagidList=" + tagidList
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
