package com.quzhigang.mapper;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.quzhigang.model.CityModel;


public interface CityMapper {
	
	String columns ="id,province_id,city_name,description";
	
	String insert = "province_id,city_name,description";
	
	String insertProperty = "#{provinceId},#{cityName},#{description}";
	
	String update = "province_id=#{provinceId},city_name=#{cityName},description=#{description}";
	
	@Insert("insert into city("+insert+") values ("+insertProperty+")")
	@Options(useGeneratedKeys=true, keyProperty="id")
	public long insert(CityModel CityModel);
	
	@Select("select "+columns+" from city where 1=1 and id= #{id}")
	@ResultMap(value="com.quzhigang.mapper.CityMapper.CityModelMap")
	public CityModel queryById(long id);
	
	@Update("update city set "+update+" where 1=1 and id = #{id}")
	public long update(CityModel CityModel);
	
	@Delete("delete from city where 1=1 and id = #{id}")
	public long delete(long id);
	
	@InsertProvider(type=com.quzhigang.provider.CityProvider.class,method="batchInsert")
	long batchInsert(Map<String, List<CityModel>> map);
	
	@InsertProvider(type=com.quzhigang.provider.CityProvider.class,method="batchDelete")
	long batchDelete(String ids);
	

	
	

}
