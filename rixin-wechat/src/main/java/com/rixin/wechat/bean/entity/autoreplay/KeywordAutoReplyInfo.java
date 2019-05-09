package com.rixin.wechat.bean.entity.autoreplay;

import java.util.List;

/**
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class KeywordAutoReplyInfo {
    private List<AutoReplyRule> list;

    public List<AutoReplyRule> getList() {
        return list;
    }

    public void setList(List<AutoReplyRule> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "KeywordAutoReplyInfo{" +
                "list=" + list +
                '}';
    }
}
