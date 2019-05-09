package com.rixin.data.service;

import com.rixin.base.dao.BaseDao;
import com.rixin.base.service.BaseService;
import com.rixin.data.dao.mapper.SysOrderDetailDao;
import com.rixin.data.domain.SysOrderDetail;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * User: dairan
 * Date: 2019-03-31 14:42
 */
@Service
public class SysOrderDetailService extends BaseService<SysOrderDetail, Integer> {

    @Resource
    private SysOrderDetailDao sysOrderDetailDao;


    @Override
    public BaseDao<SysOrderDetail, Integer> getDao() {
        return sysOrderDetailDao;
    }
}
