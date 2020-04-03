package com.donvi.controller;

import com.donvi.entity.Book;
import com.donvi.entity.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

/**
 * @Description:
 * @Author: yangdongwei
 * @CreateDate: 2019/10/19
 * @Version: 1.0
 */
@RequestMapping("/demo")
@RestController
@Validated
public class DemoController {

    @PostMapping("/book")
    public void addBook(@RequestBody @Valid Book book){
        System.out.println(book.toString());
    }

    @PostMapping("/user")
    public void addUser(@RequestBody @Valid User user){
        System.out.println(user.toString());
    }

    // 此方法直接抛ConstraintViolationException异常，返回调用方500
    @PostMapping("/userInfo")
    public void userInfo(@RequestParam @NotEmpty String name, @RequestParam @NotEmpty String age){
        System.out.println(name + "---" + age);
    }

}
