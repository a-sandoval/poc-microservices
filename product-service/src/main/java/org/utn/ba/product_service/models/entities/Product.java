package org.utn.ba.product_service.models.entities;

import jakarta.persistence.*;

@Table
@Entity
public class Product {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column
        private String nombre;
}


