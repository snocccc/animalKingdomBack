package com.pinoypliks.co.animalkingdom.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orderItem")

public class order_Item {

    order_Item(){}

    private @Id
    @GeneratedValue Long orderitemId;
    private Long orderId;
    private Long productId;
    private int Quantity;
    private double Price;

    


    public order_Item(Long orderId, Long productId, int quantity, double price) {
        this.orderId = orderId;
        this.productId = productId;
        Quantity = quantity;
        Price = price;
    }

    //Setter
   

    public void setOrderId(Long orderId){
        this.orderId = orderId;
    }

    public void setProductId(Long productId){
        this.productId = productId;
    }

    public void setQuantity(int Quantity){
        this.Quantity = Quantity;
    }

    public void setPrice(double Price){
        this.Price = Price;
    }


    //Getter
    

    public Long getOrderItemId(){
        return orderitemId;
    }

    public Long getOrderId(){
        return orderId;
    }

    public Long getProductId(){
        return productId;
    }

    public int getQuality(){
        return Quantity;
    }

    public double getPrice(){
        return Price;
    }


}
