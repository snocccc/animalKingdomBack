package com.pinoypliks.co.animalkingdom.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pinoypliks.co.animalkingdom.Model.Order;
import com.pinoypliks.co.animalkingdom.NotFoundException.OrderNotfoundException;
import com.pinoypliks.co.animalkingdom.Repository.OrderRepository;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {

    OrderRepository repo;

    public OrderController(OrderRepository repo){
        this.repo = repo;
    }

    @GetMapping("/allr")
    public List<Order>getOrder(){
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id){
        return repo.findById(id)
        .orElseThrow(()-> new OrderNotfoundException(id));
    }

    @PostMapping("/New")
    public String addOrder(@RequestBody Order newOrder){
        repo.save(newOrder);
        return "Your order was Place";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Long id){
        repo.deleteById(id);
        return "Your Order was Terminate";
    }

}
