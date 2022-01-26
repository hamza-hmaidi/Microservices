package com.microserviceProject.ProductsCommand.data;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
@Data
@Document(indexName = "productindex")
public class ProductEntity {
    @Id
    private String id;

    @Field(type = FieldType.Text)
    private  String title;

    @Field(type = FieldType.Double)
    private  Float price;

    @Field(type = FieldType.Integer)
    private  Integer quantity;
}