package com.rixin.wechat.bean.entity.poi;

/**
 * 门店信息.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class Poi {
    private Business business;

    public Poi(Business business) {
        this.business = business;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    @Override
    public String toString() {
        return "Poi{" +
                "business=" + business +
                '}';
    }
}
