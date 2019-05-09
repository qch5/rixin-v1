package com.rixin.data.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * User: dairan
 * Date: 2017 - 07 - 29 15:06
 */
public class SysOrderInfo implements Serializable {
    private Integer id;             // ID主键
    private String openid;          // 用户Id
    private String fullName;        // 姓名
    private String orderName;       // 订单名称
    private Date orderTime;         // 预约时间
    private Double prices;          // 原价
    private Double discount;        // 折扣价
    private Byte payWay;            // 支付方式 0: 微信 1: 余额
    private Double payment;         // 支付金额
    private String address;         // 服务地址
    private String comment;         // 用户备注
    private String mobile;          // 手机号
    private Byte status;            // 服务状态 -1: 订单取消 0: 完成下单 1: 完成支付 2: 订单完成 3: 服务中
    private Date createTime;        // 创建日期
    private Date updateTime;        // 更新日期

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Double getPrices() {
        return prices;
    }

    public void setPrices(Double prices) {
        this.prices = prices;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Byte getPayWay() {
        return payWay;
    }

    public void setPayWay(Byte payWay) {
        this.payWay = payWay;
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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