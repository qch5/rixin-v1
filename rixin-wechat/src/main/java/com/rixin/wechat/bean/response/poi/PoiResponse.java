package com.rixin.wechat.bean.response.poi;

import com.rixin.wechat.bean.entity.poi.BusinessResult;
import com.rixin.wechat.bean.response.BaseResponse;

/**
 * 门店信息返回.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class PoiResponse extends BaseResponse {
    private BusinessResult business;

    public BusinessResult getBusiness() {
        return business;
    }

    public void setBusiness(BusinessResult business) {
        this.business = business;
    }

    @Override
    public String toString() {
        return "PoiResponse{"
                + "business=" + business
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
