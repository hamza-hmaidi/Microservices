package com.microserviceProject.ProductsCommand;

import com.microserviceProject.ProductsCommand.events.ProductCreatedEvent;
import com.microserviceProject.ProductsCommand.commands.CreateProductCommand;
import com.microserviceProject.ProductsCommand.helpers.MQConfig;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

@Aggregate
public class ProductAggregate {
    @AggregateIdentifier
    private  String productId;
    private  String title;
    private  Float price;
    private  Integer quantity;
    @Autowired
    private RabbitTemplate template;

    public ProductAggregate(){}

    @CommandHandler
    public ProductAggregate(CreateProductCommand createProductCommand){

        //Aggregate command handler can do validation to the command
        if(createProductCommand.getPrice()<=0){
            throw new IllegalArgumentException("price cannot be less or equal to zero");
        }
        if(createProductCommand.getTitle()==null){
            throw new IllegalArgumentException("title cannot be empty");
        }

        //Create new event
        ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent();
        BeanUtils.copyProperties(createProductCommand,productCreatedEvent);

        //publish the event
        AggregateLifecycle.apply(productCreatedEvent);
    }

    @EventSourcingHandler
    public void on(ProductCreatedEvent productCreatedEvent){
        //change the aggregate state
        this.productId = productCreatedEvent.getProductId();
        this.title = productCreatedEvent.getTitle();
        this.price = productCreatedEvent.getPrice();
        this.quantity = productCreatedEvent.getQuantity();
    }


}













