package org.utn.ba.product_service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductOutputDTO {

    private Long id;
    private String name;
    private Float price;
}
