package com.tenaquare.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

/**
 * ClassName: SearchApplication
 *
 * @Author: Light
 * @Date: 2019/4/23 16:37
 * Description:
 */
@SpringBootApplication
public class SearchApplication  {
    public static void main(String[] args) {
        SpringApplication.run(SearchApplication.class);
    }

    @Bean
    public IdWorker idWorker(){
      return   new IdWorker(1,1);
    }
}