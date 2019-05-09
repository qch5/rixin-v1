package com.rixin.data.service;

import com.rixin.base.dao.BaseDao;
import com.rixin.base.service.BaseService;
import com.rixin.data.dao.mapper.SysAreaInfoDao;
import com.rixin.data.domain.SysAreaInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * User: dairan
 * Date: 2019-03-31 14:40
 */
@Service
public class SysAreaInfoService extends BaseService<SysAreaInfo, Integer> {

    @Resource
    private SysAreaInfoDao sysAreaInfoDao;



    @Override
    public BaseDao<SysAreaInfo, Integer> getDao() {
        return sysAreaInfoDao;
    }
}
