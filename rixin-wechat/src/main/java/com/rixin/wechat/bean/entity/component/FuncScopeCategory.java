package com.rixin.wechat.bean.entity.component;

/**
 * 权限集编号信息.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class FuncScopeCategory {
    private Integer id; // 权限集编号

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "FuncScopeCategory{" +
                "id=" + id +
                '}';
    }
}
