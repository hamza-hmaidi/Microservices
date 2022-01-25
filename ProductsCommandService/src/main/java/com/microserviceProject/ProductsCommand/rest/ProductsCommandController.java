package com.microserviceProject.ProductsCommand.rest;

import com.microserviceProject.ProductsCommand.commands.CreateProductCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductsCommandController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String createProduct(@RequestBody CreateProductRestModel createProductRestModel){

        CreateProductCommand createProductCommand = CreateProductCommand.builder()
                .price(createProductRestModel.getPrice())
                .quantity(createProductRestModel.getQuantity())
                .title(createProductRestModel.getTitle())
                .productId(UUID.randomUUID().toString()).build();

        String returnValue;

        try{
            returnValue = commandGateway.sendAndWait(createProductCommand);
        }catch (Exception ex){
            returnValue = ex.getLocalizedMessage();
        }

        return returnValue;
    }


    @GetMapping
    public String getProduct(){
        return "products";
    }

}
