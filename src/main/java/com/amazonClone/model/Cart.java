package com.amazonClone.model;

import java.util.Date;
import java.util.List;

import com.amazonClone.utils.IDgenerator;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cart")
@Data
public class Cart {
    @Id
    private String id;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private List<CartItem> products;

    private double total;

    private double cartTotal;

    private double deliveryCharge;

    private double tip;

    private double handlingCharge;

    private double totalAfterDiscount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User orderBy;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    
    public Cart() {
   	 this.id = IDgenerator.generateUniqueId();
   }
}
