package com.microserviceProject.ProductsCommand.query;

import com.microserviceProject.ProductsCommand.data.ProductEntity;
import com.microserviceProject.ProductsCommand.rest.ProductRestModel;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.microserviceProject.ProductsCommand.data.ProductsRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductsQueryHandler {
    @Autowired
    ProductsRepository productsRepository;
    @QueryHandler
    public List<ProductRestModel> findProducts(FindProductsQuery findProductsQuery){
        List<ProductRestModel> productsRest = new ArrayList<>();
        List<ProductEntity> savedProducts = productsRepository.findAll();
        for(ProductEntity productEntity:savedProducts){
            ProductRestModel product = new ProductRestModel();
            BeanUtils.copyProperties(productEntity,product);
            productsRest.add(product);
        }
        return productsRest;
    }

}
