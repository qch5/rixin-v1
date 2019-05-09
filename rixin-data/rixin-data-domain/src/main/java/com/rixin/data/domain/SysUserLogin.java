package com.rixin.data.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * User: dairan
 * Date: 2017 - 07 - 29 15:06
 */
public class SysUserLogin implements Serializable {
    private Integer id;         // 主键ID
    private String nickName;    // 昵称
    private String loginName;   // 登录名
    private String mobile;      // 手机号
    private Byte status;        // 状态 0: 正常 1: 异常
    private Date createTime;    // 修改日期
    private Date updateTime;    // 更新日期

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}