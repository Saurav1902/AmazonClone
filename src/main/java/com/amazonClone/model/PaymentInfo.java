package com.amazonClone.model;

import com.amazonClone.utils.IDgenerator;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "payment_info")
@Data
public class PaymentInfo {
	
    @Id
    private String id;
    private String razorPayOrderId;
    private String razorPayPaymentId;
    private String paidWith;
    
    public PaymentInfo() {
   	 this.id = IDgenerator.generateUniqueId();
   }

}
