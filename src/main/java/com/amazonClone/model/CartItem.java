package com.amazonClone.model;

import com.amazonClone.utils.IDgenerator;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cart_items")
@Data
public class CartItem {
    @Id
    private String id;

    @Column(nullable = false)
    private int count;

    @Column
    private String color;

    @Column(nullable = false)
    private double price;
    
    public CartItem() {
   	 this.id = IDgenerator.generateUniqueId();
   }

}
