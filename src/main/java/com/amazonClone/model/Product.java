package com.amazonClone.model;

import java.util.Date;
import java.util.List;

import com.amazonClone.utils.IDgenerator;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class Product {
	
    @Id
    private String id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, unique = true)
    private String slug;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productcat_id")
    private ProdCategory category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @Column(nullable = false)
    private String details;

    @ElementCollection
    private List<String> tags;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private int sold;

    @ElementCollection
    private List<String> images;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "product_color",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "color_id"))
    private List<Color> colors;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id")
    private User seller;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Rating> ratings;

    private double totalRating;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    
    public Product() {
   	 this.id = IDgenerator.generateUniqueId();
   }

}
