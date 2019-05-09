package com.rixin.wechat.bean.response.user;

import com.rixin.wechat.bean.entity.user.Tag;
import com.rixin.wechat.bean.response.BaseResponse;

import java.util.List;

/**
 * 用户标签信息列表返回.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class TagsResponse extends BaseResponse {
    private List<Tag> tags;

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "TagResponse{"
                + ", tags=" + tags
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
