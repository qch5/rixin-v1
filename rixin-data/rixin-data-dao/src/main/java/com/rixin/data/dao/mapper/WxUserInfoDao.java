package com.rixin.data.dao.mapper;

import com.rixin.base.dao.BaseDao;
import com.rixin.data.domain.WxUserInfo;

/**
 * User: dairan
 * Date: 2019-04-14 20:33
 */
public interface WxUserInfoDao extends BaseDao<WxUserInfo, Integer> {

    WxUserInfo selectByOpenId(String openId);

    int updateByOpenId(WxUserInfo info);
}
