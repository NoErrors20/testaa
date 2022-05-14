package com.example.goodsui.controller;

import com.example.goodscommon.pojo.Book;
import com.example.goodscommon.vo.ResultVo;
import com.example.goodsui.service.GoodsUiService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/ui")
public class GoodsUiController {

    @Resource
    private GoodsUiService goodsUiService;

    @RequestMapping("/test")
    public String test(){
        goodsUiService.testGoodsProvider();
        return "success";
    }

    /**
     * 查询所有图书
     */
    @RequestMapping("/list")
    @ResponseBody
    public List<Book> findAll(){
        return goodsUiService.findAll();
    }

    @RequestMapping("/detail/{id}")
    @ResponseBody
    public ResultVo detail(@PathVariable("id")Integer id){
        ResultVo book = goodsUiService.getBookDetail(id);
        return book;
    }

    @PostMapping("/add")
    public String add(@RequestBody Book book){
        return goodsUiService.addBook(book);

    }

}
