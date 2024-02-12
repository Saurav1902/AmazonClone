package com.amazonClone.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import com.amazonClone.utils.IDgenerator;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    private String id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String mobile;

    @Column(nullable = false)
    private String password;

    private String profile;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false)
    private boolean isBlocked;

    @OneToMany(mappedBy = "orderBy")
    private List<Cart> cart;

    private String address;

    @ManyToMany
    @JoinTable(name = "user_wishlist",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> wishlist;

    private String refreshToken;

    private String otp;

    private Date passwordChangedAt;

    private String passwordResetToken;

    private Date passwordResetExpires;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    
    public User() {
   	 this.id = IDgenerator.generateUniqueId();
   }
    
//    @PrePersist
//    @PreUpdate
//    public void hashPassword() {
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        this.password = passwordEncoder.encode(this.password);
//    }

    public String generateAuthToken() {
        // Assuming you have a secret key defined
        String secretKey = "amaz_clone";
        // Assuming you have a user ID field
        return Jwts.builder()
                   .setSubject(String.valueOf(this.id))
                   .setIssuedAt(new Date())
                   .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 day
                   .signWith(SignatureAlgorithm.HS512, secretKey)
                   .compact();
    }

//    public boolean isPasswordMatched(String password) {
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        return passwordEncoder.matches(password, this.password);
//    }

    public String createPasswordResetToken() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[32];
        random.nextBytes(bytes);
        String resetToken = Base64.getEncoder().encodeToString(bytes);
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(resetToken.getBytes());
            this.passwordResetToken = Base64.getEncoder().encodeToString(hashBytes);
            this.passwordResetExpires = new Date(System.currentTimeMillis() + 600000); // 10 minutes
            // Save this information to the database
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return resetToken;
    }

	public User(String firstname, String lastname, String email, String mobile, String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
	}

}
