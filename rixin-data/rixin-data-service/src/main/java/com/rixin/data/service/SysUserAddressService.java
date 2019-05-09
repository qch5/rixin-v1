package com.rixin.data.service;

import com.rixin.base.dao.BaseDao;
import com.rixin.base.service.BaseService;
import com.rixin.data.dao.mapper.SysUserAddressDao;
import com.rixin.data.domain.SysUserAddress;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * User: dairan
 * Date: 2019-03-31 14:43
 */
@Service
public class SysUserAddressService extends BaseService<SysUserAddress, Integer> {

    @Resource
    private SysUserAddressDao sysUserAddressDao;

    public List<SysUserAddress> selectByOpenId(String openid) {
        return sysUserAddressDao.selectByOpenId(openid);
    }

    @Override
    public BaseDao<SysUserAddress, Integer> getDao() {
        return sysUserAddressDao;
    }
}
