package com.example.customerui.controller;

import com.example.customerui.fegin.CustomerUIFegin;
import com.example.goodscommon.pojo.User;
import com.example.goodscommon.vo.ResultVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {
    @Resource
    private CustomerUIFegin customerUIFegin;
    @RequestMapping("/list")
    public List<User> list(){
        List<User> users = customerUIFegin.getUserList();
        return users;
    }
    @RequestMapping("/detail/{id}")
    public ResultVo detail(@PathVariable("id") int id){
        return customerUIFegin.getUserById(id);

    }
}
