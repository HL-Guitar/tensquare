package com.tenaquare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * ClassName: configApplication
 *
 * @Author: Light
 * @Date: 2019/7/7 16:27
 * Description:
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigApplication
{
    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class);
    }
}