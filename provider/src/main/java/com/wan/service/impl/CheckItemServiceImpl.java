package com.wan.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wan.dao.TCheckitemMapper;
import com.wan.pojo.CheckItem;
import com.wan.pojo.TCheckitem;
import com.wan.service.CheckItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

// 开启事务需要指定接口类
@Service(interfaceClass = com.wan.service.CheckItemService.class)
@Transactional
public class CheckItemServiceImpl implements CheckItemService {

    @Autowired
    private TCheckitemMapper tCheckitemMapper;

    public void test() {
        System.out.println("get ping");
    }

    public void test2(TCheckitem tCheckitem) {
        System.out.println("get item:" + tCheckitem.toString());
        tCheckitemMapper.insert(tCheckitem);
    }

}
