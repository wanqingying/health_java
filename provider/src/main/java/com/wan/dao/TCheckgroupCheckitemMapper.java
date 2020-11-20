package com.wan.dao;

import com.wan.pojo.TCheckgroupCheckitem;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;

public interface TCheckgroupCheckitemMapper {
    int deleteByPrimaryKey(@Param("checkgroupId") Integer checkgroupId, @Param("checkitemId") Integer checkitemId);

    int insert(TCheckgroupCheckitem record);

    int insertByMap(HashMap<String, Integer> map);

    int insertSelective(TCheckgroupCheckitem record);
}