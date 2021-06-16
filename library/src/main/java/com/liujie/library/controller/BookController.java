package com.liujie.library.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liujie.library.entity.Book;
import com.liujie.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 刘比
 * @since 2021-05-26
 */
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/findAll/{pageno}/{pagesize}")
    public IPage<Book> findAll(@PathVariable("pageno") Integer pageno,@PathVariable("pagesize") Integer pagesize){
        Integer pageNo=pageno;
        Integer pageSize=pagesize;
        IPage<Book> page=new Page<>(pageNo,pageSize);
        QueryWrapper<Book> wrapper=new QueryWrapper<>();
        return bookService.page(page,wrapper);
    }

}

