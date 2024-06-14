package org.utn.ba.orderservice.dto;

import lombok.Getter;
import lombok.Setter;
import org.utn.ba.orderservice.models.Order;

@Getter
@Setter
public class OrderDTO {
    private Long id;
    private String product;

    public OrderDTO(Order order, String product) {
        this.id = order.getId();
        this.product = product;
    }

}