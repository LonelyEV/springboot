/**
 * Project Name:springboot
 * File Name:CityQuery.java
 * Package Name:com.example.springboot.query
 * Date:2017年6月11日下午5:57:11
 * Copyright (c) 2017, Shanghai Law Cloud Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.example.springboot.query;

import com.example.springboot.common.QueryBase;

import io.swagger.annotations.Api;

/**
 * ClassName:CityQuery <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年6月11日 下午5:57:11 <br/>
 * @author   屈志刚  598700560@qq.com
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class CityQuery extends QueryBase{
	
	private Integer id;
	private Integer provinceId;
	private String cityName;
	private String description;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}

