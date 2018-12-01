package com.example.demo.service.impl;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author wen
 * @Date 2018/11/12 11:37
 * @Description
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getList(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);//改行紧挨着想要分页的方法
        List<User> users = userMapper.selectAll();
        return users;
    }
}
