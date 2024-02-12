package com.amazonClone.service;

import java.util.List;

import com.amazonClone.model.ProdCategory;

public interface ProductCategoryService {
	 List<ProdCategory> getAllCategories();
	 
	 List<ProdCategory> saveAllData(List<ProdCategory> productCategories);

	 

}
