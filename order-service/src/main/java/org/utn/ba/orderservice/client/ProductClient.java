package org.utn.ba.orderservice.client;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.utn.ba.orderservice.models.Product;

@FeignClient(name = "product-service", url = "http://localhost:9811", fallback = ProductClientFallBack.class)
public interface ProductClient {

    @GetMapping("/products/{id}")
    Product getProductById(@PathVariable("id") Long id);

}

