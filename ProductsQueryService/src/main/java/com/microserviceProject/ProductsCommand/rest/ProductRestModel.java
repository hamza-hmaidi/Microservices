package com.microserviceProject.ProductsCommand.rest;

import lombok.Data;

@Data
public class ProductRestModel {
    private String title;
    private Float price;
    private Integer quantity;
}
