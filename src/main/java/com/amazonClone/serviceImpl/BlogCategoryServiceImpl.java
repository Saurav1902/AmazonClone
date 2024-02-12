package com.amazonClone.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonClone.model.BlogCategory;
import com.amazonClone.repository.BlogCategoryRepository;
import com.amazonClone.service.BlogCategoryService;

@Service
public class BlogCategoryServiceImpl implements BlogCategoryService{
	@Autowired
	private BlogCategoryRepository blogCategoryRepository;

	@Override
	public List<BlogCategory> saveAllData(List<BlogCategory> blogCategories) {
		// TODO Auto-generated method stub
		return blogCategoryRepository.saveAll(blogCategories);
	}

}
