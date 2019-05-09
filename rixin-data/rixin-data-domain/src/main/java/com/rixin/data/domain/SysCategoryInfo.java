package com.rixin.data.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * User: dairan
 * Date: 2017 - 07 - 29 15:06
 */
public class SysCategoryInfo implements Serializable {
    private Integer id;         // 分类ID
    private String name;        // 分类名称
    private Byte level;         // 等级 1: 一级分类 2: 二级分类
    private Integer parent;     // 父分类ID
    private String path;        // 路径
    private String image;       // 图标
    private String fullName;    // 分类全称
    private Byte status;        // 状态 0: 有效 1: 无效
    private Date createTime;    // 添加日期
    private Date updateTime;    // 更新日期

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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