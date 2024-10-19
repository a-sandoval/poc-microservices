package org.utn.ba.product_service.mappers;

import org.utn.ba.product_service.dto.ProductOutputDTO;
import org.utn.ba.product_service.models.entities.Product;



public class ProductMapper {

    public static ProductOutputDTO createFrom (Product product) {

        return ProductOutputDTO
                .builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }
}
