package com.rixin.data.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * User: dairan
 * Date: 2017 - 07 - 29 15:06
 */
public class SysOrderFlow implements Serializable {
    private Integer id;         // 主键ID
    private String orderNo;     // 订单编号
    private String operator;    // 操作人
    private String mobile;      // 手机号
    private Byte status;        // 状态 -1: 订单取消 0: 用户下单 1: 完成支付 2: 订单完成 3: 完成取件
    private Date createTime;    // 添加日期
    private Date updateTime;    // 更新时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
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