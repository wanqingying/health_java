package com.wan.service;

import com.wan.entity.PageResult;
import com.wan.entity.QueryPageBean;
import com.wan.pojo.TCheckitem;

import java.util.List;

public interface CheckItemService {

    public void test();

    public int add(TCheckitem tCheckitem);

    public PageResult findByPage(QueryPageBean queryPageBean);

    public boolean deleteById(Integer id);

    public boolean update(TCheckitem tCheckitem);

    public List<TCheckitem> findAll();
}
