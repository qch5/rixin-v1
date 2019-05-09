package com.rixin.wechat.bean.response.autoreplay;


import com.rixin.wechat.bean.entity.autoreplay.KeywordAutoReplyInfo;
import com.rixin.wechat.bean.entity.autoreplay.ReplyInfo;
import com.rixin.wechat.bean.response.BaseResponse;

/**
 * 自动回复信息.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class AutoReplyInfoResponse extends BaseResponse {
    private Integer isAddFriendReplyOpen; //关注后自动回复是否开启，0代表未开启，1代表开启
    private Integer isAutoreplyOpen; //消息自动回复是否开启，0代表未开启，1代表开启
    private ReplyInfo addFriendAutoreplyInfo; //关注后自动回复的信息
    private ReplyInfo messageDefaultAutoreplyInfo; //消息自动回复的信息
    private KeywordAutoReplyInfo keywordAutoreplyInfo; //关键词自动回复的信息

    public Integer getIsAddFriendReplyOpen() {
        return isAddFriendReplyOpen;
    }

    public void setIsAddFriendReplyOpen(Integer isAddFriendReplyOpen) {
        this.isAddFriendReplyOpen = isAddFriendReplyOpen;
    }

    public Integer getIsAutoreplyOpen() {
        return isAutoreplyOpen;
    }

    public void setIsAutoreplyOpen(Integer isAutoreplyOpen) {
        this.isAutoreplyOpen = isAutoreplyOpen;
    }

    public ReplyInfo getAddFriendAutoreplyInfo() {
        return addFriendAutoreplyInfo;
    }

    public void setAddFriendAutoreplyInfo(ReplyInfo addFriendAutoreplyInfo) {
        this.addFriendAutoreplyInfo = addFriendAutoreplyInfo;
    }

    public ReplyInfo getMessageDefaultAutoreplyInfo() {
        return messageDefaultAutoreplyInfo;
    }

    public void setMessageDefaultAutoreplyInfo(ReplyInfo messageDefaultAutoreplyInfo) {
        this.messageDefaultAutoreplyInfo = messageDefaultAutoreplyInfo;
    }

    public KeywordAutoReplyInfo getKeywordAutoreplyInfo() {
        return keywordAutoreplyInfo;
    }

    public void setKeywordAutoreplyInfo(KeywordAutoReplyInfo keywordAutoreplyInfo) {
        this.keywordAutoreplyInfo = keywordAutoreplyInfo;
    }

    @Override
    public String toString() {
        return "AutoReplyInfoResponse{"
                + "isAddFriendReplyOpen=" + isAddFriendReplyOpen
                + ", isAutoreplyOpen=" + isAutoreplyOpen
                + ", addFriendAutoreplyInfo=" + addFriendAutoreplyInfo
                + ", messageDefaultAutoreplyInfo=" + messageDefaultAutoreplyInfo
                + ", keywordAutoreplyInfo=" + keywordAutoreplyInfo
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
