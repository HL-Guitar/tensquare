package com.tensquare.customer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * ClassName: Customer1
 *
 * @Author: Light
 * @Date: 2019/5/19 13:12
 * Description:
 */
@Component
@RabbitListener(queues = "itcast")
public class Customer1 {

    @RabbitHandler
    public void getMsg(String msg){
        System.out.println("直接模式接收消息： "+msg);
    }
}