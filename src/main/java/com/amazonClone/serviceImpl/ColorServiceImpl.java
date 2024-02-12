package com.amazonClone.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonClone.model.Color;
import com.amazonClone.repository.ColorRepository;
import com.amazonClone.service.ColorService;

@Service
public class ColorServiceImpl implements ColorService{

	@Autowired
	private ColorRepository colorRepository;
	@Override
	public List<Color> saveAllData(List<Color> colors) {
		// TODO Auto-generated method stub
		return colorRepository.saveAll(colors);
	}

}
