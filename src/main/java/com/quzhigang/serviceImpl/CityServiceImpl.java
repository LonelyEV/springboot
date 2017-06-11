package com.quzhigang.serviceImpl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.quzhigang.mapper.CityMapper;
import com.quzhigang.model.CityModel;
import com.quzhigang.service.CityService;

@Service
public class CityServiceImpl implements CityService {
	
	@Autowired
	private CityMapper cityMapper;
	
/*	@Autowired
	private TransactionTemplate transactionTemplate;*/
	
	@Autowired
	private PlatformTransactionManager platformTransactionManager;

	@Override
	public long insert(CityModel CityModel) {
		return cityMapper.insert(CityModel);
	}

	@Override
	public CityModel queryById(long id) {
		return cityMapper.queryById(id);
	}

	@Override
	public long update(CityModel CityModel) {
		return cityMapper.update(CityModel);
	}

	@Override
	public long delete(long id) {
		return cityMapper.delete(id);
	}

	@Override
	public long batchInsert(Map<String, List<CityModel>> map) {
		return cityMapper.batchInsert(map);
	}

	@Override
	public void batchUpdate(final List<CityModel> list) {
		
		// 基于 transactionTemplate 的编程式事务
/*		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				CityModel cityModel = new CityModel();
				cityModel.setProvinceId(500);
				cityModel.setCityName("上海500");
				cityModel.setDescription("测试500");
				cityMapper.insert(cityModel);
				
				for(int i=0; i<list.size(); i++){
					CityModel city = list.get(i);
					cityMapper.update(city);
				}
				
			}
		});*/
		
		TransactionDefinition definition = new DefaultTransactionDefinition();
		TransactionStatus status = platformTransactionManager.getTransaction(definition);
		
		try{
			
			CityModel cityModel = new CityModel();
			cityModel.setProvinceId(500);
			cityModel.setCityName("上海500");
			cityModel.setDescription("测试500");
			cityMapper.insert(cityModel);
			
			for(int i=0; i<list.size(); i++){
				CityModel city = list.get(i);
				cityMapper.update(city);
			}
			
			platformTransactionManager.commit(status);
			
		}catch(Exception e){
			platformTransactionManager.rollback(status);
			throw new RuntimeException(e);
		}
		
		

	}

}
