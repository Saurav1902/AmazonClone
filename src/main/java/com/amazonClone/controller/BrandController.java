package com.amazonClone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazonClone.model.Brand;
import com.amazonClone.service.BrandService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/brand/")
public class BrandController {
	
	@Autowired
	private BrandService brandService;
	
	@PostMapping
	public List<Brand> pushData(@RequestBody List<Brand> brands){
		return brandService.saveAllData(brands);
	}

}
