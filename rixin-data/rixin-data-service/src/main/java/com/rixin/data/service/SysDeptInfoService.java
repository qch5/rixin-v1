package com.rixin.data.service;

import com.rixin.base.dao.BaseDao;
import com.rixin.base.service.BaseService;
import com.rixin.data.dao.mapper.SysDeptInfoDao;
import com.rixin.data.domain.SysDeptInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * User: dairan
 * Date: 2019-03-31 14:41
 */
@Service
public class SysDeptInfoService extends BaseService<SysDeptInfo, Integer> {

    @Resource
    private SysDeptInfoDao sysDeptInfoDao;


    @Override
    public BaseDao<SysDeptInfo, Integer> getDao() {
        return sysDeptInfoDao;
    }
}
