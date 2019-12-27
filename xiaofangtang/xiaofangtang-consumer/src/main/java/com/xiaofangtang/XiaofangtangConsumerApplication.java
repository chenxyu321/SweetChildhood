package com.xiaofangtang;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
public class XiaofangtangConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(XiaofangtangConsumerApplication.class, args);
    }

}
