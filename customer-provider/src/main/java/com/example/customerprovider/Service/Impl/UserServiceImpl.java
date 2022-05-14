package com.example.customerprovider.Service.Impl;

import com.example.customerprovider.Mapper.UserMapper;
import com.example.customerprovider.Service.UserService;
import com.example.goodscommon.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }
}
