package com.wan.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wan.dao.TCheckgroupCheckitemMapper;
import com.wan.dao.TCheckgroupMapper;
import com.wan.dao.TCheckitemMapper;
import com.wan.pojo.TCheckgroup;
import com.wan.pojo.TCheckgroupCheckitem;
import com.wan.pojo.TCheckitem;
import com.wan.service.CheckGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@Service(interfaceClass = com.wan.service.CheckGroupService.class)
@Transactional
public class CheckGroupImpl implements CheckGroupService {

    @Autowired
    private TCheckgroupMapper tCheckgroupMapper;
    @Autowired
    private TCheckgroupCheckitemMapper tCheckgroupCheckitemMapper;

    @Override
    public void insert(TCheckgroup group) {
        int res = tCheckgroupMapper.insert(group);
        ArrayList<TCheckitem> items = group.getCheckitems();
        HashMap<String, Integer> map = new HashMap<>();
        for (TCheckitem tCheckitem : items) {
            map.put("checkgroupId", group.getId());
            map.put("checkitemId", tCheckitem.getId());
            tCheckgroupCheckitemMapper.insertByMap(map);
            map.clear();
//            TCheckgroupCheckitem tCheckgroupCheckitem=new TCheckgroupCheckitem();
//            tCheckgroupCheckitem.setCheckgroupId(group.getId());
//            tCheckgroupCheckitem.setCheckitemId(tCheckitem.getId());
        }
        System.out.println("insert_ID:" + group.getId());
    }
}
