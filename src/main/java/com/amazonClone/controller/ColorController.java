package com.amazonClone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazonClone.model.Color;
import com.amazonClone.service.ColorService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/color/")
public class ColorController {
	
	@Autowired
	private ColorService colorService;
	
	@PostMapping
	public List<Color> pushData(@RequestBody List<Color> colors){
		return colorService.saveAllData(colors);
	}


}
