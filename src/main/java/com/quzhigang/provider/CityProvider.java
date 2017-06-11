package com.quzhigang.provider;


import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import com.quzhigang.model.CityModel;

public class CityProvider {
	
	String columns = "id,province_id,city_name,description";
	
	String insert = "province_id,city_name,description";
	
	String insertProperty = "#{provinceId},#{cityName},#{description}";
	
	public String batchInsert(Map<String, List<CityModel>> map){
		
		List<CityModel> list = map.get("list");
		
		StringBuffer sql = new StringBuffer(" insert into city ("+insert+")");
		sql.append(" values ");
		MessageFormat mFormat = new MessageFormat("(#'{'list[{0}].provinceId},#'{'list[{0}].cityName},#'{'list[{0}].description})");
		
		for(int i=0; i<list.size(); i++){
			sql.append(mFormat.format(new Object[]{i}));
			if(i<list.size() - 1){
				sql.append(",");
			}
		}
		
		return sql.toString();
	}
	
	public String batchDelete(String ids){
		
		StringBuffer sql = new StringBuffer();
		
		return sql.toString();
	}
	
	

}
