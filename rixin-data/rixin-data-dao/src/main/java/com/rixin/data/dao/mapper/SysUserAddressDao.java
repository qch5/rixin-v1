package com.rixin.data.dao.mapper;

import com.rixin.base.dao.BaseDao;
import com.rixin.data.domain.SysUserAddress;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * User: dairan
 * Date: 2019-03-31 14:29
 */
public interface SysUserAddressDao extends BaseDao<SysUserAddress, Integer> {

    List<SysUserAddress> selectByOpenId(@Param("openid") String openid);
}