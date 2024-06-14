package org.utn.ba.orderservice.models;


import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;

@Table(name="`order`")
@Entity
@Getter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long productId;
}
