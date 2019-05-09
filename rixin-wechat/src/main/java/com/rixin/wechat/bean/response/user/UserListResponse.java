package com.rixin.wechat.bean.response.user;

import com.rixin.wechat.bean.entity.user.User;
import com.rixin.wechat.bean.response.BaseResponse;

import java.util.List;

public class UserListResponse extends BaseResponse {
    private List<User> userInfoList;

    public List<User> getUserInfoList() {
        return userInfoList;
    }

    public void setUserInfoList(List<User> userInfoList) {
        this.userInfoList = userInfoList;
    }

    @Override
    public String toString() {
        return "UserListResponse{"
                + "userInfoList=" + userInfoList
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
