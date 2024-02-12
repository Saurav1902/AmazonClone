package com.amazonClone.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

import com.amazonClone.utils.IDgenerator;

@Entity
@Table(name = "coupons")
@Data
public class Coupon {
	
    @Id
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date expiry;

    @Column(nullable = false)
    private double discount;
    
    public Coupon() {
   	 this.id = IDgenerator.generateUniqueId();
   }

}
