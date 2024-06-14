package org.utn.ba.orderservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.utn.ba.orderservice.client.ProductClient;
import org.utn.ba.orderservice.models.Order;
import org.utn.ba.orderservice.models.Product;
import org.utn.ba.orderservice.repositories.OrderRepository;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductClient productClient;

    @PostMapping
    public ResponseEntity<Order> createOrden(@RequestBody Order order) {

        Product product = productClient.getProductById(order.getProductId());
        if (product == null) {
            return ResponseEntity.badRequest().build();
        }


        return ResponseEntity.ok(orderRepository.save(order));
    }

    @GetMapping
    public List<Order> getAllOrdenes() {
        return orderRepository.findAll();
    }
}