package com.microserviceProject.ProductsCommand.events;

import com.microserviceProject.ProductsCommand.helpers.MQConfig;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventsHandler {

    @Autowired
    private RabbitTemplate template;
    @EventHandler
    public void publishEventCreated(ProductCreatedEvent productCreatedEvent){
        String msg = "hello";
        template.convertAndSend(MQConfig.QUEUE,productCreatedEvent);
    }
}
