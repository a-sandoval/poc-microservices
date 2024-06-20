package org.utn.ba.orderservice.client;

import org.springframework.stereotype.Component;
import org.utn.ba.orderservice.models.Product;

@Component
public class ProductClientFallBack implements ProductClient{
    @Override
    public Product getProductById(Long id) {
        Product productFallBack = new Product();
        productFallBack.setId(id);
        productFallBack.setName("Fallback Response: No se pudo obtener el detalle del Producto ID: " + id);
        return productFallBack;
    }
}
