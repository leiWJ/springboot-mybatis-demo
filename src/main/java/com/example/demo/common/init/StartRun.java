/*
 *
 * 项目名：	com.shop.ddm.config
 * 文件名：	LoadGames
 * 模块说明：
 * 修改历史：
 * 2018/4/27 - JOHN - 创建。
 */

package com.example.demo.common.init;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

/**
 * Web 容器启动后会运行 run 方法
 */
@EnableScheduling
@Component
public class StartRun implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}
