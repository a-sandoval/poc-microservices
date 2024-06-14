package org.utn.ba.orderservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.utn.ba.orderservice.client.ProductClient;
import org.utn.ba.orderservice.dto.OrderDTO;
import org.utn.ba.orderservice.models.Order;
import org.utn.ba.orderservice.models.Product;
import org.utn.ba.orderservice.repositories.OrderRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductClient productClient;


    @GetMapping
    public List<OrderDTO> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(order -> {
            Product product = productClient.getProductById(order.getProductId());
            return new OrderDTO(order, product.getName());
        }).collect(Collectors.toList());
    }
}