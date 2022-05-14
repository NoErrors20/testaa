package com.example.goodsprovider.service;

import com.example.goodscommon.pojo.Book;

import java.util.List;

public interface GoodsProviderService {
    List<Book> findAll();

    Book getBookDetail(Integer id);

    void addBook(Book book);
}
