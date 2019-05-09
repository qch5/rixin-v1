package com.rixin.data.service;

import com.rixin.base.dao.BaseDao;
import com.rixin.base.service.BaseService;
import com.rixin.data.dao.mapper.SysUserLoginDao;
import com.rixin.data.domain.SysUserLogin;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * User: dairan
 * Date: 2019-03-31 14:43
 */
@Service
public class SysUserLoginService extends BaseService<SysUserLogin, Integer> {

    @Resource
    private SysUserLoginDao sysUserLoginDao;


    @Override
    public BaseDao<SysUserLogin, Integer> getDao() {
        return sysUserLoginDao;
    }
}
