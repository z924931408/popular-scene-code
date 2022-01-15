package com.zhu.fte.biz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhu.fte.biz.entity.UserInfo;
import com.zhu.fte.biz.mapper.UserInfoMapper;
import com.zhu.fte.biz.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public int save(UserInfo userInfo) {
        return userInfoMapper.insert(userInfo);
    }

    @Override
    public List<UserInfo> getUserList() {
        return userInfoMapper.selectList(null);
    }
}
