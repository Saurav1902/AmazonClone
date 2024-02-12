package com.amazonClone.model;

import java.time.LocalDateTime;
import com.amazonClone.utils.IDgenerator;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "brand")
public class Brand {
	
	@Id
    private String id;

    @Column(unique = true)
    private String title;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;
    
    
    public Brand() {
    	 this.id = IDgenerator.generateUniqueId();
    }
    
    @PrePersist
    public void prePersist() {
		createdAt = LocalDateTime.now(); 
		updatedAt = LocalDateTime.now(); 
    }

}
