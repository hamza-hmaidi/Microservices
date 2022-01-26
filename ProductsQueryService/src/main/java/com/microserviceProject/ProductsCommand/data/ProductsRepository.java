package com.microserviceProject.ProductsCommand.data;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ProductsRepository extends ElasticsearchRepository<ProductEntity, String> {
    List<ProductEntity> findByTitle(String name);

    List<ProductEntity> findByTitleContaining(String name);

    List<ProductEntity> findByTitleAndPrice
            (String manufacturer, String category);
    List<ProductEntity> findAll();
}
