package com.example.springboot.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.ServerRunner;
import com.example.springboot.model.CityModel;
import com.example.springboot.service.CityService;

/**
 * 
 * ClassName: TestCity <br/>
 * Function: CityService测试 <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2017年6月11日 下午5:51:20 <br/>
 *
 * @author 屈志刚  598700560@qq.com
 * @version 
 * @since JDK 1.7
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=ServerRunner.class)
public class TestCity {
	
	
	@Autowired
	private CityService cityService;
	
	@Test
	public void testCity(){
		CityModel cityModel = new CityModel();
		cityModel.setProvinceId(100);
		cityModel.setDescription("测试");
		cityModel.setCityName("湖南长沙");
		
		cityService.insert(cityModel);
	}

}
