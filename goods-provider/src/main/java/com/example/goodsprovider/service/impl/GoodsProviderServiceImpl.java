package com.example.goodsprovider.service.impl;

import com.example.goodscommon.pojo.Book;
import com.example.goodsprovider.mapper.GoodsProviderMapper;
import com.example.goodsprovider.service.GoodsProviderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsProviderServiceImpl implements GoodsProviderService {

    @Resource
    private GoodsProviderMapper goodsProviderMapper;

    @Override
    public List<Book> findAll() {
        return goodsProviderMapper.findAll();
    }

    @Override
    public Book getBookDetail(Integer id) {
        Book book = goodsProviderMapper.getBookDetail(id);
        return book;
    }

    @Override
    public void addBook(Book book) {
        goodsProviderMapper.addBook(book);
    }
}
