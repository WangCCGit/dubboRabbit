package com.it.rabbit.RabbitProducer;

import com.it.rabbit.config.RabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("one")
@RestController
public class OneController {


    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping(value = "email",method = RequestMethod.GET)
    public void sendMessage(){
        //指定交换机名   routingkey 还有要发送的信息
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_TOPICS_INFORM,
                "inform.email","say hello");
    }

}
