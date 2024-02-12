package com.amazonClone.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonClone.model.ProdCategory;
import com.amazonClone.repository.ProductCategoryRepository;
import com.amazonClone.service.ProductCategoryService;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService{
	@Autowired
	private ProductCategoryRepository categoryRepository;
	
	@Override
    public List<ProdCategory> getAllCategories() {
        return categoryRepository.findAll();
    }

	@Override
	public List<ProdCategory> saveAllData(List<ProdCategory> productCategories) {
		// TODO Auto-generated method stub
		return categoryRepository.saveAll(productCategories);
	}

}
