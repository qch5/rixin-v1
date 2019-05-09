package com.rixin.data.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * User: dairan
 * Date: 2017 - 07 - 29 15:06
 */
public class SysOrderDetail implements Serializable {
    private Long id;                // 主键ID
    private String orderNo;         // 订单号
    private String itemId;          // 商品ID
    private String itemName;        // 商品名称
    private String itemImage;       // 图片地址
    private Integer number;         // 数量
    private Double price;           // 原价
    private Double discount;        // 折扣价
    private Date createTime;        // 添加日期
    private Date updateTime;        // 修改日期

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
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