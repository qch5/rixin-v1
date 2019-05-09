package com.rixin.data.service;

import com.rixin.base.dao.BaseDao;
import com.rixin.base.service.BaseService;
import com.rixin.data.dao.mapper.WxUserInfoDao;
import com.rixin.data.domain.WxUserInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * User: dairan
 * Date: 2019-04-14 20:43
 */
@Service
public class WxUserInfoService extends BaseService<WxUserInfo, Integer> {

    @Resource
    private WxUserInfoDao wxUserInfoDao;

    public WxUserInfo selectByOpenId(String openId) {
        return wxUserInfoDao.selectByOpenId(openId);
    }

    public int updateByOpenId(WxUserInfo info) {
        return wxUserInfoDao.updateByOpenId(info);
    }

    @Override
    public BaseDao<WxUserInfo, Integer> getDao() {
        return wxUserInfoDao;
    }
}
