package com.bookProject.bookStore.repository;

import com.bookProject.bookStore.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
