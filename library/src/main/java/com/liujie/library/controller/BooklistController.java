package com.liujie.library.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.liujie.library.entity.Booklist;
import com.liujie.library.service.BooklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
@RequestMapping("/booklist")
public class BooklistController {

    @Autowired
    private BooklistService booklistService;

    @GetMapping("/findAll/{pageno}/{pagesize}")
    public IPage<Booklist> findAll(@PathVariable("pageno") Integer pageno, @PathVariable("pagesize") Integer pagesize){
        Integer pageNo=pageno;
        Integer pageSize=pagesize;
        IPage<Booklist> page=new com.baomidou.mybatisplus.extension.plugins.pagination.Page<>(pageNo,pageSize);
        QueryWrapper<Booklist> wrapper=new QueryWrapper<>();
        return booklistService.page(page,wrapper);
    }

}

