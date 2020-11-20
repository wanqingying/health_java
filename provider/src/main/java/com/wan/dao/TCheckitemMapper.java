package com.wan.dao;

import com.github.pagehelper.Page;
import com.wan.pojo.TCheckitem;

import java.util.ArrayList;

public interface TCheckitemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TCheckitem record);

    int insertSelective(TCheckitem record);

    TCheckitem selectByPrimaryKey(Integer id);

    Page<TCheckitem> findByPage(String search);

    Long findByCountGroup(Integer id);

    int updateByPrimaryKeySelective(TCheckitem record);

    int updateByPrimaryKey(TCheckitem record);

    ArrayList<TCheckitem> findAll();
}