package com.example.goodsprovider.mapper;

import com.example.goodscommon.pojo.Book;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GoodsProviderMapper {
    List<Book> findAll();

    Book getBookDetail(Integer id);

    void addBook(Book book);
}
