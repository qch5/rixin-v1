package com.rixin.data.service;

import com.rixin.base.dao.BaseDao;
import com.rixin.base.service.BaseService;
import com.rixin.data.dao.mapper.SysCategoryInfoDao;
import com.rixin.data.domain.SysCategoryInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * User: dairan
 * Date: 2019-03-31 14:41
 */
@Service
public class SysCategoryInfoService extends BaseService<SysCategoryInfo, Integer> {

    @Resource
    private SysCategoryInfoDao sysCategoryInfoDao;


    @Override
    public BaseDao<SysCategoryInfo, Integer> getDao() {
        return sysCategoryInfoDao;
    }
}
