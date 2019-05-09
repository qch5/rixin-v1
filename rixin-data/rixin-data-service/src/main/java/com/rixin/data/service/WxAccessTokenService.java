package com.rixin.data.service;

import com.rixin.base.dao.BaseDao;
import com.rixin.base.service.BaseService;
import com.rixin.data.dao.mapper.WxAccessTokenDao;
import com.rixin.data.domain.WxAccessToken;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * User: dairan
 * Date: 2019-04-14 18:59
 */
@Service
public class WxAccessTokenService extends BaseService<WxAccessToken, Integer> {

    @Resource
    private WxAccessTokenDao wxAccessTokenDao;

    /**
     * 获取access_token
     */
    public WxAccessToken selectAccessToken(String appId, String appSecret) {
        return wxAccessTokenDao.selectAccessToken(appId, appSecret);
    }

    /**
     * 更新access_token
     */
    public WxAccessToken insertAccessToken(WxAccessToken token) {
        wxAccessTokenDao.insert(token);
        return token;
    }

    @Override
    public BaseDao<WxAccessToken, Integer> getDao() {
        return wxAccessTokenDao;
    }
}
