package com.example.customerprovider;

import com.example.customerprovider.Service.Impl.UserServiceImpl;
import com.example.customerprovider.Service.UserService;
import com.example.goodscommon.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest

class CustomerProviderApplicationTests {
@Autowired
private UserServiceImpl userService;
    @Test
    void contextLoads() {
        List<User> users = userService.findAll();
        System.out.println(users.toString());
    }

}
