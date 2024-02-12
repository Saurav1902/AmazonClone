package com.amazonClone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amazonClone.model.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, String>{

}
