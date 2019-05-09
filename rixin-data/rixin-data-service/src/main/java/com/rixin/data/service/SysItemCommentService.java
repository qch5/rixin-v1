package com.rixin.data.service;

import com.rixin.base.dao.BaseDao;
import com.rixin.base.service.BaseService;
import com.rixin.data.dao.mapper.SysItemCommentDao;
import com.rixin.data.domain.SysItemComment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * User: dairan
 * Date: 2019-03-31 14:42
 */
@Service
public class SysItemCommentService extends BaseService<SysItemComment, Integer> {

    @Resource
    private SysItemCommentDao sysItemCommentDao;


    @Override
    public BaseDao<SysItemComment, Integer> getDao() {
        return sysItemCommentDao;
    }
}
