package com.amazonClone.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserDto {
	
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


}
