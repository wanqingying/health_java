package com.wan.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wan.pojo.TCheckgroup;
import com.wan.service.CheckGroupService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/group")
public class CheckGroupController {

    @Reference
    private CheckGroupService checkGroupService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String addCheckGroup(@RequestBody TCheckgroup tCheckgroup) {
        checkGroupService.insert(tCheckgroup);
        return "ok";
    }
}
