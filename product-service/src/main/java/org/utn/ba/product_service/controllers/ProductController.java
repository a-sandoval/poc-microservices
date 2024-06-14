package org.utn.ba.product_service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.utn.ba.product_service.models.entities.Product;
import org.utn.ba.product_service.models.repositories.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepository.getReferenceById(id);
    }
}
