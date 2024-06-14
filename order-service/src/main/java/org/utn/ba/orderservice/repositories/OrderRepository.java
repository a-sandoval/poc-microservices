package org.utn.ba.orderservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.utn.ba.orderservice.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
