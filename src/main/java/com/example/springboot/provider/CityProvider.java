/**
 * Project Name:springboot
 * File Name:CityProvider.java
 * Package Name:com.example.springboot.provider
 * Date:2017年6月11日下午5:56:44
 * Copyright (c) 2017, Shanghai Law Cloud Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.example.springboot.provider;

import org.apache.commons.lang.StringUtils;

import com.example.springboot.query.CityQuery;

/**
 * ClassName:CityProvider <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年6月11日 下午5:56:44 <br/>
 * @author   屈志刚  598700560@qq.com
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class CityProvider {
	
	String columns = "id, province_id, city_name, description";
	
	public String fetchPageAdvance(CityQuery query) {
		StringBuffer sql = new StringBuffer("select "+columns+" from city where 1=1 ");
		
		if(query != null){
			
			if(query.getId() > 0){
				sql.append(" and id = #{id}");
			}
			
			if(query.getProvinceId() > 0){
				sql.append(" and province_id = #{provinceId}");
			}
			
			if(!StringUtils.isBlank(query.getCityName())){
				sql.append(" and city_name = #{cityName}");
			}
			
			if(!StringUtils.isBlank(query.getDescription())){
				sql.append(" and description = #{description}");
			}
		}
		
		if (StringUtils.isNotBlank(query.getOrderBy())) {
			sql.append(" order by " + query.getOrderBy());
		}
		if (query.getPageSize() > 0) {
			sql.append(" limit " + query.getStartRow() + "," + query.getPageSize());
		}

		return sql.toString();
	}

	public String fetchPageAdvanceCount(CityQuery query) {
		
		StringBuffer sql = new StringBuffer("select count(1) from city where 1=1 ");
       
		if(query != null){
			
			if(query.getId() > 0){
				sql.append(" and id = #{id}");
			}
			
			if(query.getProvinceId() > 0){
				sql.append(" and province_id = #{provinceId}");
			}
			
			if(!StringUtils.isBlank(query.getCityName())){
				sql.append(" and city_name = #{cityName}");
			}
			
			if(!StringUtils.isBlank(query.getDescription())){
				sql.append(" and description = #{description}");
			}
		}
		
		return sql.toString();
	}

}

