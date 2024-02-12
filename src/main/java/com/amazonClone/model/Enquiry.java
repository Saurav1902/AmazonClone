package com.amazonClone.model;

import jakarta.persistence.*;
import java.util.Date;

import com.amazonClone.utils.IDgenerator;

@Entity
@Table(name = "enquiry")
public class Enquiry {
	
    @Id
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String mobile;

    @Column(nullable = false)
    private String message;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    
    public Enquiry() {
   	 this.id = IDgenerator.generateUniqueId();
   }

}
