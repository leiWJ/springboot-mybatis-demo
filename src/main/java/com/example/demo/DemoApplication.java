package com.example.demo;

import com.example.demo.base.MyMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(value = "com.example.demo.dao", markerInterface = MyMapper.class)
@PropertySource(value = {"classpath:myProperties/app_config.properties"}, encoding = "utf-8")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
