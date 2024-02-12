package com.amazonClone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amazonClone.model.ProdCategory;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProdCategory, Long> {

}
