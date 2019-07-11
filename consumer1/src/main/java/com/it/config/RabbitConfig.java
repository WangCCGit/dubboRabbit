package com.it.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    //队列名
    public static final String QUEUE_INFORM_EMAIL="queue_inform_email";
    // 交换机名
    public static final String EXCHANGE_TOPICS_INFORM="exchange_topics_inform";
    // 路由key #可替代多个单词  $站位符
    public static final String ROUTINGKEY="inform.#.email";

    //声明队列
    @Bean(QUEUE_INFORM_EMAIL)
    public Queue QUEUE_INFORM_EMAIL(){
        return new Queue(QUEUE_INFORM_EMAIL);
    }

    //交换机
    @Bean(EXCHANGE_TOPICS_INFORM)
    public Exchange EXCHANGE_TOPICS_INFORM(){
        return ExchangeBuilder.topicExchange(EXCHANGE_TOPICS_INFORM).durable(true).build();
    }

    //队列绑定交换机 指定routingkey
    @Bean
    public Binding BINDING(@Qualifier(QUEUE_INFORM_EMAIL)Queue queue,
                           @Qualifier(EXCHANGE_TOPICS_INFORM)Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(ROUTINGKEY).noargs();
    }


}
