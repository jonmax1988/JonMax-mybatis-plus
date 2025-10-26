package com.jonmax.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jonmax.domain.User;
import com.jonmax.mapper.UserMapper;
import com.jonmax.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

//    @Autowired
//    UserMapper userMapper;
//    @Override
//    public List<User> selectAllUser() {
//        return userMapper.selectList(null);
//    }

}
