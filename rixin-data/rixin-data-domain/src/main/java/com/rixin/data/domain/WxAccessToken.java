package com.rixin.data.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * User: dairan
 * Date: 2019-04-14 18:16
 */
public class WxAccessToken implements Serializable {
    private Integer id;             // 主键
    private String access_token;    // 凭证密钥
    private Integer expires_in;     // 凭证有效日期
    private String appId;           // 应用ID
    private String appSecret;       // 应用密码
    private Date createTime;        // 添加日期
    private Date updateTime;        // 更新日期

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Integer getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Integer expires_in) {
        this.expires_in = expires_in;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
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
