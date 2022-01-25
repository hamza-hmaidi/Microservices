package com.microserviceProject.ProductsCommand.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
