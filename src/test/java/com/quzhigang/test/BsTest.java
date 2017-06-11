package com.quzhigang.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.quzhigang.model.CityModel;
import com.quzhigang.service.CityService;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spirng-config.xml", "classpath:spring-mybatis.xml" })
public class BsTest {
	
	@Autowired
	private CityService cityService;
	
	@Test
	public void test(){
		
		CityModel cityModel = new CityModel();
		cityModel.setProvinceId(898989);
		cityModel.setCityName("上海001");
		cityModel.setDescription("测试88");
		
		Assert.assertEquals(1, cityService.insert(cityModel)); 
	}

}
