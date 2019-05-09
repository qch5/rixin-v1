package com.rixin.data.service;

import com.rixin.base.dao.BaseDao;
import com.rixin.base.service.BaseService;
import com.rixin.data.dao.mapper.SysItemInfoDao;
import com.rixin.data.domain.SysItemInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * User: dairan
 * Date: 2019-03-31 14:42
 */
@Service
public class SysItemInfoService extends BaseService<SysItemInfo, Integer> {

    @Resource
    private SysItemInfoDao sysItemInfoDao;


    @Override
    public BaseDao<SysItemInfo, Integer> getDao() {
        return sysItemInfoDao;
    }
}
