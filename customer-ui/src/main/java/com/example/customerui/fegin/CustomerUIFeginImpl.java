package com.example.customerui.fegin;

import com.example.goodscommon.pojo.User;
import com.example.goodscommon.vo.ResultVo;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CustomerUIFeginImpl implements CustomerUIFegin{
    @Override
    public List<User> getUserList() {
        return null;
    }

    @Override
    public ResultVo getUserById(int id) {
        return  ResultVo.wrong("feign的服务降级响应lalla");
    }
}
