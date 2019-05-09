package com.rixin.data.dao.mapper;

import com.rixin.base.dao.BaseDao;
import com.rixin.data.domain.SysOrderInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * User: dairan
 * Date: 2019-03-31 14:29
 */
public interface SysOrderInfoDao extends BaseDao<SysOrderInfo, Integer> {

    List<SysOrderInfo> selectByOpenId(@Param("openid") String openid);
}