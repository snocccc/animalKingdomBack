package com.pinoypliks.co.animalkingdom.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ordertbl")
public class Order {

    Order(){}

    private @Id
    @GeneratedValue Long id;
    private Long userId;
    private double totalAmount;
    private String Status;


    public Order(Long userId, double totalAmount, String Status){
        userId = userId;
        totalAmount = totalAmount;
        Status = Status;
    }

    //Setter
    public void setOrderId(Long orderId) {
        this.userId = userId;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    

    //Getter

    public Long getId(){
        return id;
    }

    public Long getUserId(){
        return userId;
    }

    public double getTotalAmount(){
        return totalAmount;
    }

    public String getStatus(){
        return Status;
    }
}
