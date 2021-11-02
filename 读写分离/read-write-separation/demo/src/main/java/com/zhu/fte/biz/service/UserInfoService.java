package com.zhu.fte.biz.service;

import com.zhu.fte.biz.entity.UserInfo;

import java.util.List;

public interface UserInfoService {
    int save(UserInfo userInfo);
    List<UserInfo> getUserList();
}
