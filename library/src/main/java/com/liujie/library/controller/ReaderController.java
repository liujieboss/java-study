package com.liujie.library.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liujie.library.entity.Reader;
import com.liujie.library.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 刘比
 * @since 2021-05-26
 */
@RestController
@RequestMapping("/reader")
public class ReaderController {
    @Autowired
    private ReaderService readerService;

    @PostMapping("/register")
    public String register(@RequestBody Reader reader){
        boolean result=false;
        try{
            result=readerService.save(reader);
        }catch (Exception e){
            e.printStackTrace();
        }

        if(result){
            return "success";
        }else{
            return "fail";
        }
    }

    @GetMapping("/login/{userName}/{passWd}")
    public String login(@PathVariable("userName") String userName,@PathVariable("passWd") String passWd){
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("user_name",userName);
        wrapper.eq("pass_wd",passWd);
        Reader reader = null;
        try {
            reader = readerService.getOne(wrapper);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //如果用户存在，并且密码正确
        if(reader!=null){
            return "success";
        }else{
            wrapper=new QueryWrapper();
            wrapper.eq("user_name",userName);
            try {
                reader=readerService.getOne(wrapper);
            } catch (Exception e) {
                e.printStackTrace();
            }

            //如果用户存在，但是密码错误
            if(reader!=null){
                return "fail";
            }else {
                //如果用户不存在
                return "NoUser";
            }
        }
    }


}

