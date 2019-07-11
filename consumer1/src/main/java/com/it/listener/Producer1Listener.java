package com.it.listener;

import com.it.config.RabbitConfig;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Producer1Listener {

    //直接监听队列

    @RabbitListener(queues = RabbitConfig.QUEUE_INFORM_EMAIL)
    public void receive_massage(String msg, Message message, Channel channel){
        System.out.println(msg);
    }

}
