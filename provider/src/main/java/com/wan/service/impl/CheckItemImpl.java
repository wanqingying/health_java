package com.wan.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wan.dao.TCheckitemMapper;
import com.wan.entity.PageResult;
import com.wan.entity.QueryPageBean;
import com.wan.pojo.CheckItem;
import com.wan.pojo.TCheckitem;
import com.wan.service.CheckItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

// 开启事务需要指定接口类
@Service(interfaceClass = com.wan.service.CheckItemService.class)
@Transactional
public class CheckItemImpl implements CheckItemService {

    @Autowired
    private TCheckitemMapper tCheckitemMapper;

    public void test() {
        System.out.println("get ping");
    }

    public int add(TCheckitem tCheckitem) {
        System.out.println("add item:" + tCheckitem.toString());
        return tCheckitemMapper.insert(tCheckitem);
    }

    @Override
    public PageResult findByPage(QueryPageBean queryPageBean) {
        String search = queryPageBean.getSearch();
        var current = queryPageBean.getCurrent();
        Integer size = queryPageBean.getSize();
        PageHelper.startPage(current, size);
        Page<TCheckitem> page = tCheckitemMapper.findByPage(search);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public boolean deleteById(Integer id) {
        Long count = tCheckitemMapper.findByCountGroup(id);
        if (count > 0) {
            return false;
        }
        int del = tCheckitemMapper.deleteByPrimaryKey(id);
        return del > 0;
    }

    @Override
    public boolean update(TCheckitem tCheckitem) {
        int res = tCheckitemMapper.updateByPrimaryKey(tCheckitem);
        return res > 0;
    }

    @Override
    public List<TCheckitem> findAll() {
        return tCheckitemMapper.findAll();
    }


}
