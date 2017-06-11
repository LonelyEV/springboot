package com.quzhigang.service;


import java.util.List;
import java.util.Map;

import com.quzhigang.model.CityModel;

public interface CityService {
	
	public long insert(CityModel CityModel);
	public CityModel queryById(long id);
	public long update(CityModel CityModel);
	public long delete(long id);
	public long batchInsert(Map<String, List<CityModel>> map);
	public void batchUpdate(List<CityModel> list);

}
