package com.wan.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.wan.constant.MessageConstant;
import com.wan.entity.PageResult;
import com.wan.entity.QueryPageBean;
import com.wan.entity.Result;
import com.wan.pojo.TCheckitem;
import com.wan.service.CheckItemService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/checks")
public class CheckItemController {

    // 查找服务
    @Reference
    private CheckItemService checkItemService;

    @RequestMapping("/test")
    public String test() {
        checkItemService.add(new TCheckitem());
        return "test ok";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result addCheckItem(@RequestBody TCheckitem tCheckitem) {
        try {
            int x = checkItemService.add(tCheckitem);
            return new Result(true, MessageConstant.ADD_CHECKITEM_SUCCESS, x);
        } catch (Exception e) {
            return new Result(false, MessageConstant.ADD_CHECKITEM_FAIL, 0);
        }
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public PageResult findItemListByPage(@RequestBody QueryPageBean queryPageBean) {
        return checkItemService.findByPage(queryPageBean);
    }

    @RequestMapping("/delete")
    public Result deleteById(@RequestParam("id") Integer id) {
        boolean res = checkItemService.deleteById(id);
        if (res) {
            return new Result(true, MessageConstant.DELETE_CHECKGROUP_SUCCESS);
        } else {
            return new Result(true, MessageConstant.DELETE_CHECKGROUP_FAIL);
        }
    }

    @RequestMapping(value = "/update")
    public Result updateById(@RequestBody TCheckitem tCheckitem) {
        try {
            boolean res = checkItemService.update(tCheckitem);
            if (res) {
                return new Result(true, MessageConstant.EDIT_CHECKITEM_SUCCESS);
            } else {
                return new Result(false, MessageConstant.EDIT_CHECKITEM_FAIL);
            }
        } catch (Exception e) {
            return new Result(false, e.getMessage());
        }
    }

    @RequestMapping("/all")
    public Result findAll() {
        try {
            List<TCheckitem> res = checkItemService.findAll();
            return new Result(true, "ok", res);
        } catch (Exception e) {
            return new Result(false, e.getMessage(), new ArrayList<>());
        }
    }
}
