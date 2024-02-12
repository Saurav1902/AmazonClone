package com.amazonClone.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

import com.amazonClone.utils.IDgenerator;

@Entity
@Table(name = "sessions")
@Data
public class Session {
	
    @Id
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private boolean valid;

    @Column(nullable = false)
    private String userAgent;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    
    public Session() {
   	 this.id = IDgenerator.generateUniqueId();
   }

}
