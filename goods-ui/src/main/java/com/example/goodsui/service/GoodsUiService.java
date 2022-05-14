package com.example.goodsui.service;

import com.example.goodscommon.pojo.Book;
import com.example.goodscommon.vo.ResultVo;

import java.util.List;

public interface GoodsUiService {

     void testGoodsProvider();

    List<Book> findAll();

    ResultVo getBookDetail(Integer id);

    String addBook(Book book);
}
