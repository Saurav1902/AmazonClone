package com.amazonClone.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

import com.amazonClone.utils.IDgenerator;

@Entity
@Table(name = "blogs")
public class Blog {
    @Id
    private String id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private BlogCategory category;

    @Column(nullable = false)
    private int numViews;

    @Column(nullable = false)
    private boolean isLiked;

    @Column(nullable = false)
    private boolean isDisliked;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "blog_likes",
            joinColumns = @JoinColumn(name = "blog_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> likes;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "blog_dislikes",
            joinColumns = @JoinColumn(name = "blog_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> dislikes;

    @Column(nullable = false)
    private String image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private User author;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public Blog() {
   	 this.id = IDgenerator.generateUniqueId();
   }
}
