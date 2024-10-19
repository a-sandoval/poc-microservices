package org.utn.ba.product_service.controllers;

import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.utn.ba.product_service.dto.ProductInputDTO;
import org.utn.ba.product_service.dto.ProductOutputDTO;
import org.utn.ba.product_service.models.entities.Product;
import org.utn.ba.product_service.models.repositories.ProductRepository;
import org.utn.ba.product_service.services.IProductService;

import java.util.Optional;

@RestController
@RequestMapping(value = "/products", produces = "application/json")
public class ProductController {


    @Autowired
    private IProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<ProductOutputDTO> getProductById(@PathVariable Long id) {

        ProductOutputDTO product = this.productService.findById(id);

        if(product == null)
            throw new NotFoundException("No product was found with ID" + id);

        return ResponseEntity.ok(this.productService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Long> createProduct(@RequestBody ProductInputDTO productInputDTO) {

        Long id = this.productService.createProduct(productInputDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }
}
