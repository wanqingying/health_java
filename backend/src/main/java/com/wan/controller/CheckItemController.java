package com.wan.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.wan.constant.MessageConstant;
import com.wan.entity.PageResult;
import com.wan.entity.QueryPageBean;
import com.wan.entity.Result;
import com.wan.pojo.TCheckitem;
import com.wan.service.CheckItemService;
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
        checkItemService.add(new TCheckitem());
        return "test ok";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result addCheckItem(@RequestBody TCheckitem tCheckitem) {
        System.out.println("add :" + tCheckitem.toString());
        try {
            int x = checkItemService.add(tCheckitem);
            return new Result(true, MessageConstant.ADD_CHECKITEM_SUCCESS, x);
        } catch (Exception e) {
            return new Result(false, MessageConstant.ADD_CHECKITEM_FAIL, 0);
        }
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public PageResult findItemListByPage(@RequestBody QueryPageBean queryPageBean) {
        System.out.println("list:" + queryPageBean.getSearch());
        return checkItemService.findByPage(queryPageBean);
    }
}
