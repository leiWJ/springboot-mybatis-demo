package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.base.Result;
import com.example.demo.base.ResultUtil;
import com.example.demo.dao.UserMapper;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


/**
 * @Author wen
 * @Date 2018/11/12 14:56
 * @Description
 **/
@RestController
@RequestMapping("/redis-test")
@Api(description = "测试redis")
public class RedisController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private UserMapper userMapper;

    private static final int capacity = 1000000;
    private static BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), capacity);


    @GetMapping("/test1")
    @ApiOperation("测试redis")
    public Result test1() {
        String value = stringRedisTemplate.opsForValue().get("key");
        //字符串转对象
        Map map = JSON.parseObject(value, Map.class);
        return ResultUtil.getSuccessJson();
    }
}
