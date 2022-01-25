package com.microserviceProject.ProductsCommand.data;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name="products")
public class ProductEntity implements Serializable {

    private static final long serialVersionUID = -22222245487654L;

    @Id
    @Column(unique = true)
    private  String productId;

    @Column(unique = true)
    private  String title;

    private  Float price;

    private  Integer quantity;

}