package com.tensquare.spit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

/**
 * ClassName: SpitApplication
 *
 * @Author: Light
 * @Date: 2019/4/22 14:51
 * Description:
 */

@SpringBootApplication
public class SpitApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpitApplication.class);
    }

    @Bean
    public IdWorker idWorkker(){
        return new IdWorker(1, 1);
    }
}