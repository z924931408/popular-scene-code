package com.zhu.fte.biz.controller;

import com.zhu.fte.biz.entity.UserInfo;
import com.zhu.fte.biz.service.UserInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserInfoService userInfoService;

    @GetMapping("/select")
    public List<UserInfo> select(){
        return userInfoService.getUserList();
    }

    @PostMapping("/insert")
    public int insert(UserInfo userInfo){
        return userInfoService.save(userInfo);
    }
}
