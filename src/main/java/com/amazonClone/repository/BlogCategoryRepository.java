package com.amazonClone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amazonClone.model.BlogCategory;

@Repository
public interface BlogCategoryRepository extends JpaRepository<BlogCategory, String>{

}
