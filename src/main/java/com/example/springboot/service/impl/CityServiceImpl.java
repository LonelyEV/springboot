package com.example.springboot.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.mapper.CityMapper;
import com.example.springboot.model.CityModel;
import com.example.springboot.query.CityQuery;
import com.example.springboot.service.CityService;

@Service
public class CityServiceImpl implements CityService {
	
	@Autowired
	private CityMapper CityService;

	@Override
	public long insert(CityModel cityModel) {
		
		return CityService.insert(cityModel);
	}

	@Override
	public void del(Integer id) {
		
		CityService.del(id);
	}

	@Override
	public long update(CityModel carOrder) {
		
		return CityService.update(carOrder);
	}

	@Override
	public CityModel getById(Integer id) {
		
		return CityService.getById(id);
	}

	@Override
	public List<CityModel> findAll() {
		
		return CityService.findAll();
	}

	@Override
	public int findAllCount() {
		
		return CityService.findAllCount();
	}

	@Override
	public List<CityModel> fetchPageAdvance(CityQuery query) {
		
		return CityService.fetchPageAdvance(query);
	}

	@Override
	public int fetchPageAdvanceCount(CityQuery query) {
		
		return CityService.fetchPageAdvanceCount(query);
	}



}
