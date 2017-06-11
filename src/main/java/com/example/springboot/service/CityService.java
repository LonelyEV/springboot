package com.example.springboot.service;


import java.util.List;

import com.example.springboot.model.CityModel;
import com.example.springboot.query.CityQuery;


public interface CityService {
	
	public long insert(CityModel cityModel);
	
	public void del(Integer id);
	
	public long update(CityModel carOrder); 
	
	public CityModel getById(Integer id);
	
	public List<CityModel> findAll();
	
	public int findAllCount();
	
	public List<CityModel> fetchPageAdvance(CityQuery query);  
	
	public int fetchPageAdvanceCount(CityQuery query);

}
