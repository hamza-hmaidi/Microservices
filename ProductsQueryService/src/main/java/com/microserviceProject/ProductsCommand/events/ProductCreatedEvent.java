package com.microserviceProject.ProductsCommand.events;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class ProductCreatedEvent implements Serializable {
    private  String productId;
    private  String title;
    private  Float price;
    private  Integer quantity;
}
