package com.example.demo.common.init;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author wen
 * @date 2020/5/8 16:57
 * @Description 启动加载
 **/
@Component
public class MySelfCache implements InitializingBean {


    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
