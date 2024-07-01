package com.pinoypliks.co.animalkingdom.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pinoypliks.co.animalkingdom.Model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
