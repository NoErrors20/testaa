package com.example.customerui.fegin;

import com.example.goodscommon.pojo.User;
import com.example.goodscommon.vo.ResultVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@FeignClient(value = "customer-provider",fallback = CustomerUIFeginImpl.class)
public interface CustomerUIFegin {
    @GetMapping("/user/list")
    List<User> getUserList();
    @GetMapping("/user/detail")
    ResultVo getUserById(@RequestParam("id") int id);
}
