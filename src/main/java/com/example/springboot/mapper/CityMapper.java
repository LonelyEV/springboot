package com.example.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.example.springboot.model.CityModel;
import com.example.springboot.query.CityQuery;

@Mapper
public interface CityMapper {
	
	
	String columns = "id, province_id, city_name, description";
	
	String insertColumns = "province_id, city_name, description";
	
	String insertProperty = "#{provinceId}, #{cityName}, #{description}";
	
	String update = "province_id=#{provinceId},city_name=#{cityName}, description=#{description}";
	
	/**
	 * 
	 * insert:(新增对象). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author 屈志刚  598700560@qq.com
	 * @param cityModel
	 * @return 当前对象自增ID
	 * @since JDK 1.7
	 */
    @Options(useGeneratedKeys=true, keyProperty="id")
    @Insert("insert into city(" + insertColumns + ") values(" + insertProperty + ")")
    long insert(CityModel cityModel);
    
    /**
     * 
     * del:(根据ID删除指定对象). <br/>
     * TODO(这里描述这个方法适用条件 – 可选).<br/> 
     * TODO(这里描述这个方法的执行流程 – 可选).<br/>
     * TODO(这里描述这个方法的使用方法 – 可选).<br/>
     * TODO(这里描述这个方法的注意事项 – 可选).<br/>
     *
     * @author 屈志刚  598700560@qq.com
     * @param id
     * @since JDK 1.7
     */
	@Delete("delete from city where  id=#{id} ")
	public void del(Integer id);
	
	/**
	 * 
	 * update:(修改对象). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author 屈志刚  598700560@qq.com
	 * @param carOrder
	 * @return
	 * @since JDK 1.7
	 */
	@Update("update city set "+update+" where id=#{id}")
	public long update(CityModel carOrder); 
	
	/**
	 * 
	 * getById:(根据ID获取对象). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author 屈志刚  598700560@qq.com
	 * @param id
	 * @return CityModel
	 * @since JDK 1.7
	 */
	@Select("select "+columns+" from city where id=#{id}")
	@ResultMap(value="com.midai.car.mapper.CityMapper.CityModelMap")
	public CityModel getById(Integer id);
	
	
	/**
	 * 
	 * findAll:(查询所有对象集合不带分页). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author 屈志刚  598700560@qq.com
	 * @return
	 * @since JDK 1.7
	 */
	@Select("select "+columns+" FROM city ")
	@ResultMap(value="com.midai.car.mapper.CityMapper.CityModelMap")
	public List<CityModel> findAll();
	
	/**
	 * 
	 * findAllCount:(查询对象总记录数不带分页). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author 屈志刚  598700560@qq.com
	 * @return
	 * @since JDK 1.7
	 */
	@Select("select count(1) from city ")
	public int findAllCount();
	
	/**
	 * 
	 * fetchPageAdvance:(根据条件查询带分页). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author 屈志刚  598700560@qq.com
	 * @param query
	 * @return
	 * @since JDK 1.7
	 */
	@SelectProvider(type=com.example.springboot.provider.CityProvider.class,method="fetchPageAdvance")
	@ResultMap(value="com.example.springboot.mapper.CityMapper.CityModelMap")
	public List<CityModel> fetchPageAdvance(CityQuery query);  
	
	/**
	 * 
	 * fetchPageAdvanceCount:(根据条件查询总记录数). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author 屈志刚  598700560@qq.com
	 * @param query
	 * @return
	 * @since JDK 1.7
	 */
	@SelectProvider(type=com.example.springboot.provider.CityProvider.class,method="fetchPageAdvanceCount")
	public int fetchPageAdvanceCount(CityQuery query);

}
