package com.rixin.wechat.bean.response.poi;

import com.rixin.wechat.bean.response.BaseResponse;

import java.util.List;

/**
 * 门店类目列表返回.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class CategoryListResponse extends BaseResponse {
    private List<String> categoryList;

    public List<String> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<String> categoryList) {
        this.categoryList = categoryList;
    }

    @Override
    public String toString() {
        return "CategoryListResponse{"
                + "categoryList=" + categoryList
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
