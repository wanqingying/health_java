package com.wan.service;

import com.wan.entity.PageResult;
import com.wan.entity.QueryPageBean;
import com.wan.pojo.TCheckitem;

public interface CheckItemService {

    public void test();

    public int add(TCheckitem tCheckitem);

    public PageResult findByPage(QueryPageBean queryPageBean);
}
