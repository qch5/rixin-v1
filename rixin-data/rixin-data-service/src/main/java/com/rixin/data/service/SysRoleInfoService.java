package com.rixin.data.service;

import com.rixin.base.dao.BaseDao;
import com.rixin.base.service.BaseService;
import com.rixin.data.dao.mapper.SysRoleInfoDao;
import com.rixin.data.domain.SysRoleInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * User: dairan
 * Date: 2019-03-31 14:44
 */
@Service
public class SysRoleInfoService extends BaseService<SysRoleInfo, Integer> {

    @Resource
    private SysRoleInfoDao sysRoleInfoDao;


    @Override
    public BaseDao<SysRoleInfo, Integer> getDao() {
        return sysRoleInfoDao;
    }
}
