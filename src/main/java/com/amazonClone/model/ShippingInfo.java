package com.amazonClone.model;

import lombok.Data;

import com.amazonClone.utils.IDgenerator;

import jakarta.persistence.*;

@Entity
@Table(name = "shipping_info")
@Data
public class ShippingInfo {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String landmark;
    private int pincode;
    private String mobile;
    
    public ShippingInfo() {
   	 this.id = IDgenerator.generateUniqueId();
   }

}
