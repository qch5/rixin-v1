package com.rixin.base.service;

import com.rixin.base.dao.BaseDao;
import com.rixin.base.page.PageMeta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.task.TaskExecutor;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * User: dairan
 * Date: 2019-03-31 15:18
 */
public abstract class BaseService<Model, PK extends Serializable> {
    private static final Logger logger = LoggerFactory.getLogger(BaseService.class);

    protected TaskExecutor taskExecutor;
    protected abstract BaseDao<Model, PK> getDao();

    public Model selectByPrimaryKey(PK id) {
        return this.getDao().selectByPrimaryKey(id);
    }

    public List<Model> selectByPage(Model info, PageMeta page) {
        return this.getDao().selectByPage(info, page);
    }

    public int updateByPrimaryKeySelective(Model record) {
        return this.getDao().updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Model record) {
        return this.getDao().updateByPrimaryKey(record);
    }

    public int insert(Model record) {
        return this.getDao().insert(record);
    }

    public int insertSelective(Model record) {
        return this.getDao().insertSelective(record);
    }

    public int deleteByPrimaryKey(PK id) {
        return this.getDao().deleteByPrimaryKey(id);
    }

    protected String makeCacheKey(Object id) {
//        return CacheKeyHelper.getEntityCacheKey(this.getTClass(), id);
//        this.cacheManager.put(CacheKeyHelper.ENTITY_REGION, this.makeCacheKey(t.getId()), t);
//        this.cacheManager.get(CacheKeyHelper.ENTITY_REGION, this.makeCacheKey(id));
//        this.cacheManager.remove(CacheKeyHelper.ENTITY_REGION, this.makeCacheKey(t.getId()));
        return "";
    }

    private Class<Model> getTClass() {
        return ((Class<Model>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }
}
