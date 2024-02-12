package com.amazonClone.model;

import com.amazonClone.utils.IDgenerator;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ratings")
@Data
public class Rating {
	
    @Id
    private String id;

    @Column(nullable = false)
    private int star;

    @Column
    private String comment;

    @Column
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
    
    public Rating() {
   	 this.id = IDgenerator.generateUniqueId();
   }

}
