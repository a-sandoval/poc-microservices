package org.utn.ba.orderservice.controllers;

import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.utn.ba.orderservice.client.ProductClient;
import org.utn.ba.orderservice.dto.OrderDTO;
import org.utn.ba.orderservice.models.Order;
import org.utn.ba.orderservice.models.Product;
import org.utn.ba.orderservice.repositories.OrderRepository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductClient productClient;

    @Autowired
    private CircuitBreaker circuitBreaker;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        try{

        List<Order> orders = orderRepository.findAll();

        List<OrderDTO> orderDTOS = orders.stream().map(order -> {
            Product product = circuitBreaker.executeSupplier(() -> productClient.getProductById(order.getProductId()));
            return new OrderDTO(order, product.getName());
        }).collect(Collectors.toList());
        return ResponseEntity.ok(orderDTOS);

        }
        catch (CallNotPermittedException e){
            System.out.println("Circuit is Open. Cannot get Products. " + e.toString());
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(Collections.emptyList());
        }
    }
}