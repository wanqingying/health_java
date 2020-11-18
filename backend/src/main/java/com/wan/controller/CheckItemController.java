package com.wan.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.wan.constant.MessageConstant;
import com.wan.entity.Result;
import com.wan.pojo.CheckItem;
import com.wan.pojo.TCheckitem;
import com.wan.service.CheckItemService;
import com.wan.service.Test2;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/checks")
public class CheckItemController {

    // 查找服务
    @Reference
    private CheckItemService checkItemService;

    @RequestMapping("/test")
    public String test() {
        System.out.println("get test");
        checkItemService.test2(new TCheckitem());
        return "test ok";
    }

    @RequestMapping(value = "test", method = RequestMethod.POST)
    public String test2(@RequestBody TCheckitem tCheckitem) {
        System.out.println("get test");
        checkItemService.test2(tCheckitem);
        return "test ok";
    }
}
