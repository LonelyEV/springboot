/**
 * Project Name:springboot
 * File Name:SpringbootController.java
 * Package Name:com.example.springboot.controller
 * Date:2017年6月11日下午5:49:50
 * Copyright (c) 2017, Shanghai Law Cloud Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.springboot.model.CityModel;
import com.example.springboot.service.CityService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * ClassName:SpringbootController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年6月11日 下午5:49:50 <br/>
 * @author   屈志刚  598700560@qq.com
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
	
	@Api(value="第一个测试器")
	@Controller
	public class SpringbootController {	
		
		@Autowired
		private CityService cityService;
		
		@ApiOperation(value="springboot测试",httpMethod="POST")
		@RequestMapping(value="/addCity",method=RequestMethod.POST)
		public ResponseEntity<String> doPengdingTranscodingTask(@RequestBody CityModel cityModel){
			cityService.insert(cityModel);
			return ResponseEntity.ok("done");
		}
	
	

}



