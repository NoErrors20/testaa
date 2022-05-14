package com.example.goodsui.service.impl;

import com.example.goodscommon.pojo.Book;
import com.example.goodscommon.vo.ResultVo;
import com.example.goodsui.service.GoodsUiService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class GoodsUiServiceImpl implements GoodsUiService {

    @Resource
    private RestTemplate restTemplate;

    @Override
    public void testGoodsProvider() {
        //1.调用服务的地址：应用名称和对应的映射url组合
        String forObject = restTemplate.getForObject("http://goods-provider/provider/test", String.class);
        System.out.println("goods-provider返回结果----->"+forObject);
    }

    @Override
    public List<Book> findAll() {
        Book[] bookList = restTemplate.getForObject("http://goods-provider/provider/list", Book[].class);
        return Arrays.asList(bookList);
    }

    @Override
    @HystrixCommand(
            fallbackMethod = "fallBackBookDetail",commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1000")
    }
    )
    public ResultVo getBookDetail(Integer id) {
        Book book = restTemplate.getForObject("http://goods-provider/provider/detail/"+id,Book.class);
        return ResultVo.success(book);
    }
    public ResultVo fallBackBookDetail(Integer id) {

        return ResultVo.wrong("服务降级返回的响应内容");
    }

    @Override
    public String addBook(Book book) {
        String msg = restTemplate.postForObject("http://goods-provider/provider/add", book, String.class);
        return msg;
    }
}
