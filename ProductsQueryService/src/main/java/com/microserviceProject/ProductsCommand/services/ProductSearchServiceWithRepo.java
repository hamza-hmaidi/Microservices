package com.microserviceProject.ProductsCommand.services;

import com.microserviceProject.ProductsCommand.data.ProductEntity;
import com.microserviceProject.ProductsCommand.data.ProductsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductSearchServiceWithRepo {
    private ProductsRepository productRepository;

    public void createProductIndexBulk(final List<ProductEntity> products) {
        productRepository.saveAll(products);
    }

    public void createProductIndex(final ProductEntity product) {
        productRepository.save(product);
    }
}
