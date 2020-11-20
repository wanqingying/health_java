package com.wan.dao;

import com.wan.pojo.TCheckgroup;

public interface TCheckgroupMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TCheckgroup record);

    int insertSelective(TCheckgroup record);

    TCheckgroup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TCheckgroup record);

    int updateByPrimaryKey(TCheckgroup record);
}