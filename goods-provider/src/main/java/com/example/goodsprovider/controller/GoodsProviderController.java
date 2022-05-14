package com.example.goodsprovider.controller;

import com.example.goodscommon.pojo.Book;
import com.example.goodsprovider.service.GoodsProviderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/provider")
public class GoodsProviderController {

    @Resource
    private GoodsProviderService goodsProviderService;

    /**
     * 测试goods-ui调用是否成功
     */
    @RequestMapping("/test")
    public String test(){
        System.out.println("进入了goods-provider");
        return "调用成功";
    }

    /**
     * 返回所有图书
     */
    @RequestMapping("/list")
    public List<Book> findAll(){
        return goodsProviderService.findAll();
    }
    @RequestMapping("/detail/{id}")
    public Book detail(@PathVariable("id")Integer id) throws InterruptedException {
//        Thread.sleep(3000);
        Book book = goodsProviderService.getBookDetail(id);
        return book;
    }

    @PostMapping("/add")
    public String add(@RequestBody Book book){
        goodsProviderService.addBook(book);
        return "success";

    }
    @HystrixCommand(fallbackMethod = "fallBack",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50")

    })
    @RequestMapping("/test_hystrix")
    public String testHystrix(@RequestParam("num")Integer num){
        int n = (int) (Math.random()*100);
        int result =  n/num;
        return "服务正常返回"+n+"/"+num+"="+result;

    }
    public String fallBack(@RequestParam("num")Integer num){
        return "服务降级响应：num为0";
    }
}
