package com.amazonClone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amazonClone.model.Color;

@Repository
public interface ColorRepository extends JpaRepository<Color, String>{

}
