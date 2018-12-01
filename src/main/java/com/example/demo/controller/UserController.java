package com.example.demo.controller;

import com.example.demo.base.Result;
import com.example.demo.base.ResultUtil;
import com.example.demo.common.page.PageInfo;
import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author wen
 * @Date 2018/11/12 11:38
 * @Description
 **/
@RestController
@RequestMapping("/user")
@Api(description = "测试swagger")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Value("${msg_appid}")
    private String appId;//自定义配置文件读取

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;


    @GetMapping("/test1")
    @ResponseBody
    @ApiOperation("test1")
    public Result test1(@RequestParam(value = "essayIds") @ApiParam(value = "文章id", required = true) List<String> essayIds) {
        User param = new User();
        param.setId(1);
        User user1 = userMapper.selectByPrimaryKey(1);
        /*List<User> userList1 = userMapper.getUserList("", "");
        List<User> userList2 = userMapper.getUserList(null, null);
        List<User> userList3 = userMapper.getUserList("111", null);
        User userRandomByUserId = userMapper.getUserRandomByUserId("111");*/
        return ResultUtil.getSuccessJson(user1);
    }


    @GetMapping("/test2")
    @ResponseBody
    @ApiOperation("分页用法")
    public Result<User> test2(@RequestParam(value = "page", defaultValue = "1") Integer page,
                        @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {

        List<User> list = userService.getList(page, pageSize);
        if (null == list) {
            return ResultUtil.getNotFoundJson();
        } else {
            PageInfo<User> pageInfo = new PageInfo<>(list);
            return ResultUtil.getSuccessJson(pageInfo);
        }
    }

}
