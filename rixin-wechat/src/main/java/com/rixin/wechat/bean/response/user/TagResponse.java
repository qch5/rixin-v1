package com.rixin.wechat.bean.response.user;

import com.rixin.wechat.bean.entity.user.Tag;
import com.rixin.wechat.bean.response.BaseResponse;

/**
 * 用户标签信息返回.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class TagResponse extends BaseResponse {
    private Tag tag;

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "TagResponse{"
                + "tag=" + tag
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
