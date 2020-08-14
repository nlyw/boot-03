package com.chenjh.service.book.impl;

import com.chenjh.entity.book.Book;
import com.chenjh.mapper.book.BookMapper;
import com.chenjh.service.book.BookService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public void select() {
        //开启分页
        PageHelper.startPage(1, 3);

        List<Book> list = bookMapper.select();
        list.forEach(b -> {
            System.out.println(b.getBookName());
        });

    }
}
