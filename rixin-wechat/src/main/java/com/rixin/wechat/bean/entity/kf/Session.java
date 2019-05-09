package com.rixin.wechat.bean.entity.kf;

/**
 * 客户会话状态.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class Session {
    private String kfAccount;
    private Long createtime;

    public String getKfAccount() {
        return kfAccount;
    }

    public void setKfAccount(String kfAccount) {
        this.kfAccount = kfAccount;
    }

    public Long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Long createtime) {
        this.createtime = createtime;
    }
}
