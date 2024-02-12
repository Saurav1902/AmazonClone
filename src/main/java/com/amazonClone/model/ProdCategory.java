package com.amazonClone.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;


import com.amazonClone.utils.IDgenerator;


@Data
@Entity
@Table(name = "category")
public class ProdCategory {
	@Id
    private String id;

    @Column(unique = true)
    private String title;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;
    
    
    public ProdCategory() {
    	 this.id = IDgenerator.generateUniqueId();
    }
    
    @PrePersist
    public void prePersist() {
		createdAt = LocalDateTime.now(); 
		updatedAt = LocalDateTime.now(); 
    }
		
}
