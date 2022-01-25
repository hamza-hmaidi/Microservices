package com.microserviceProject.ProductsCommand.events;
import com.microserviceProject.ProductsCommand.data.ProductsRepository;
import com.microserviceProject.ProductsCommand.data.ProductEntity;
import com.microserviceProject.ProductsCommand.helpers.MQConfig;
import org.axonframework.eventhandling.gateway.EventGateway;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    private EventGateway eventGateway;
    @Autowired
    ProductsRepository productsRepository;

    @RabbitListener(queues= MQConfig.QUEUE)
    public void listener(ProductCreatedEvent productCreatedEvent){
        System.out.println(productCreatedEvent);
        ProductEntity product = new ProductEntity();
        BeanUtils.copyProperties(productCreatedEvent,product);
        this.productsRepository.save(product);
        System.out.println(product.getTitle()+" product added to database successfully");
    }
}
