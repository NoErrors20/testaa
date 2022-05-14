package com.example.customerprovider.controller;

import com.example.customerprovider.Service.UserService;
import com.example.goodscommon.pojo.User;
import com.example.goodscommon.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/list")
    public List<User> findAll(){
        return userService.findAll();
    }
    @RequestMapping("/detail")
    public ResultVo detail(@RequestParam("id")int id) throws InterruptedException {
//        Thread.sleep(3000);
        User user = userService.getUserById(id);
        return ResultVo.success(user);
    }
}
