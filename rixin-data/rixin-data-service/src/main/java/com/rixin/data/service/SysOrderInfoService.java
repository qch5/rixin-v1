package com.rixin.data.service;

import com.rixin.base.dao.BaseDao;
import com.rixin.base.service.BaseService;
import com.rixin.data.dao.mapper.SysOrderInfoDao;
import com.rixin.data.domain.SysOrderInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * User: dairan
 * Date: 2019-03-31 14:43
 */
@Service
public class SysOrderInfoService extends BaseService<SysOrderInfo, Integer> {

    @Resource
    private SysOrderInfoDao sysOrderInfoDao;

    public List<SysOrderInfo> selectByOpenId(String openid) {
        return sysOrderInfoDao.selectByOpenId(openid);
    }

    @Override
    public BaseDao<SysOrderInfo, Integer> getDao() {
        return sysOrderInfoDao;
    }
}
