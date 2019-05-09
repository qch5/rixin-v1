package com.rixin.data.service;

import com.rixin.base.dao.BaseDao;
import com.rixin.base.service.BaseService;
import com.rixin.data.dao.mapper.SysUserInfoDao;
import com.rixin.data.domain.SysUserInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * User: dairan
 * Date: 2019-03-31 14:43
 */
@Service
public class SysUserInfoService extends BaseService<SysUserInfo, Integer> {

    @Resource
    private SysUserInfoDao sysUserInfoDao;


    @Override
    public BaseDao<SysUserInfo, Integer> getDao() {
        return sysUserInfoDao;
    }
}
