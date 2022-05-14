package com.example.customerprovider.Mapper;

import com.example.goodscommon.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {

    List<User> findAll();

    void insert(User user);

    void deleteBatch(@Param("ids") Integer[] ids);

    User getUserById(int id);
}
