package com.rixin.base.dao;

import com.rixin.base.page.PageMeta;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * User: dairan
 * Date: 2019-03-31 14:29
 */
public interface BaseDao<Model, PK extends Serializable> {

    Model selectByPrimaryKey(PK id);

    List<Model> selectByPage(@Param("info") Model info, @Param("page") PageMeta page);

    int updateByPrimaryKey(Model record);

    int updateByPrimaryKeySelective(Model record);

    int insert(Model record);

    int insertSelective(Model record);

    int deleteByPrimaryKey(PK id);

}
