package com.amazonClone.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonClone.model.Brand;
import com.amazonClone.repository.BrandRepository;
import com.amazonClone.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService{
	
	@Autowired
	private BrandRepository brandRepository;

	@Override
	public List<Brand> saveAllData(List<Brand> allBrands) {
		return brandRepository.saveAll(allBrands);
	}

}
