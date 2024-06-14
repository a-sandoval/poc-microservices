package org.utn.ba.orderservice.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.utn.ba.orderservice.models.Product;

@FeignClient(name = "product-service")
public interface ProductClient {

    @GetMapping("/products/{id}")
    Product getProductById(@PathVariable("id") Long id);
}