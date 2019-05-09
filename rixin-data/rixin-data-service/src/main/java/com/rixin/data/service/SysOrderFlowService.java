package com.rixin.data.service;

import com.rixin.base.dao.BaseDao;
import com.rixin.base.service.BaseService;
import com.rixin.data.dao.mapper.SysOrderFlowDao;
import com.rixin.data.domain.SysOrderFlow;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * User: dairan
 * Date: 2019-03-31 14:42
 */
@Service
public class SysOrderFlowService extends BaseService<SysOrderFlow, Integer> {

    @Resource
    private SysOrderFlowDao sysOrderFlowDao;


    @Override
    public BaseDao<SysOrderFlow, Integer> getDao() {
        return sysOrderFlowDao;
    }
}
