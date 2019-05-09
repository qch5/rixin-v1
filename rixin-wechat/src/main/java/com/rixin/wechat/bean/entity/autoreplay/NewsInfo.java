package com.rixin.wechat.bean.entity.autoreplay;

import java.util.List;

/**
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class NewsInfo {
    private List<NewsItem> list;

    public List<NewsItem> getList() {
        return list;
    }

    public void setList(List<NewsItem> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "NewsInfo{" +
                "list=" + list +
                '}';
    }
}
