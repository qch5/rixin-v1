package com.rixin.wechat.bean.response.component.wxa;

import com.rixin.wechat.bean.response.BaseResponse;
import lombok.Data;

import java.util.List;

/**
 * 查询当前设置的最低基础库版本及各版本用户占比接口返回.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
@Data
public class WeAppSupportVersionResponse extends BaseResponse {
    private String nowVersion;//当前版本
    private UvInfo uvInfo; //受影响用户占比

    @Data
    public static class UvInfo {
        List<Item> items;
    }

    @Data
    public static class Item {
        private Double percentage; //受影响比例
        private String version;
    }

    @Override
    public String toString() {
        return "WeAppSupportVersionResponse{"
                + "nowVersion='" + nowVersion + '\''
                + ", uvInfo=" + uvInfo
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
