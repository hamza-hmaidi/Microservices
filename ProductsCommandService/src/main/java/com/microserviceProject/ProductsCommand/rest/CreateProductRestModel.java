package com.microserviceProject.ProductsCommand.rest;

import lombok.Data;

@Data
public class CreateProductRestModel {
    private String title;
    private Float price;
    private Integer quantity;

}
