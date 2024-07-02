package com.pinoypliks.co.animalkingdom.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pinoypliks.co.animalkingdom.Model.order_Item;
import com.pinoypliks.co.animalkingdom.NotFoundException.OrderItemNotFoundException;
import com.pinoypliks.co.animalkingdom.Repository.OrderItemRepository;

@RestController
public class OrderItemController {

    OrderItemRepository repo;

    public OrderItemController(OrderItemRepository repo){
        this.repo = repo;
    }

    @GetMapping("/OrderItem")
    public List<order_Item>getOrder_Items(){
        return repo.findAll();
    }

    @GetMapping("/OrderItem/{id}")
    public order_Item getOrder_Item(@PathVariable Long id){
        return repo.findById(id)
        .orElseThrow(()-> new OrderItemNotFoundException(id));
    }

    @PostMapping("/OrderItem/New")
    public String addOrder_Item(@RequestBody order_Item newOrder_Item){
        repo.save(newOrder_Item);
        return "Your Order Item is Added";
    }

    @DeleteMapping("/OrderItem/Delete/{id}")
    public String deleteOrderItem(@PathVariable Long id){
        repo.deleteById(id);
        return "Your Order Item is Deleted";
    }

}
