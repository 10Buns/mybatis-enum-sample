package com.summer.sample.controller;

import com.summer.sample.dao.mapper.UserMapper;
import com.summer.sample.dao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * All rights Reserved, Designed By mapletowngames.com
 *
 * @Version V1.0
 * @Title: TestController
 * @Package com.summer.sample.controller
 * @Author: summer
 * @Date: 2019-02-22 17:19
 * @Description: 测试
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping(value = "/users")
    public List<User> getAllUsers(){
        return userMapper.getAllUser();
    }

}
