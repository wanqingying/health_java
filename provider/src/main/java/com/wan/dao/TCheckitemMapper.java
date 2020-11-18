package com.wan.dao;

import com.wan.pojo.TCheckitem;

import java.util.ArrayList;

public interface TCheckitemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TCheckitem record);

    int insertSelective(TCheckitem record);

    TCheckitem selectByPrimaryKey(Integer id);

    ArrayList<TCheckitem> findByPage();

    int updateByPrimaryKeySelective(TCheckitem record);

    int updateByPrimaryKey(TCheckitem record);
}