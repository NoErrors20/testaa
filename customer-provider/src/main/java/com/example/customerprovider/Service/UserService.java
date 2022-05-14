package com.example.customerprovider.Service;

import com.example.goodscommon.pojo.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User getUserById(int id);
}
