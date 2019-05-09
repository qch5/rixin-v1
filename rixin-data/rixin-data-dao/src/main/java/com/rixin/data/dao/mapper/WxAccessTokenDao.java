package com.rixin.data.dao.mapper;

import com.rixin.base.dao.BaseDao;
import com.rixin.data.domain.WxAccessToken;
import org.apache.ibatis.annotations.Param;

/**
 * User: dairan
 * Date: 2019-04-14 18:20
 */
public interface WxAccessTokenDao extends BaseDao<WxAccessToken, Integer> {

    WxAccessToken selectAccessToken(@Param("appId") String appId, @Param("appSecret") String appSecret);
}
