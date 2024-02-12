package com.amazonClone.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

import com.amazonClone.utils.IDgenerator;

@Entity
@Table(name = "orders")
public class Order {
	
    @Id
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "shipping_info_id")
    private ShippingInfo shippingInfo;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_info_id")
    private PaymentInfo paymentInfo;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    @Temporal(TemporalType.TIMESTAMP)
    private Date paidAt;

    @Column(nullable = false)
    private double totalPrice;
    
    public Order() {
   	 this.id = IDgenerator.generateUniqueId();
   }

}
