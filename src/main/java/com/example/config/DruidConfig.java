package com.example.config;


import java.util.Arrays;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

/**
 * 
 * ClassName: DruidConfig <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2017年6月11日 下午5:48:39 <br/>
 *
 * @author 屈志刚  598700560@qq.com
 * @version 
 * @since JDK 1.7
 */
@Order(value=Integer.MIN_VALUE+1)
@Configuration
public class DruidConfig {
	
	
	
	@Bean(name="statFilter")
	public Filter statFilter(){
		StatFilter stat=new StatFilter();
		return stat; 
	}
	

	
	
	   @Bean(name="dataSource")
	    public DataSource druidDataSource(@Value("${spring.datasource.driver-class-name}") String driver,
	                                      @Value("${spring.datasource.url}") String url,
	                                      @Value("${spring.datasource.username}") String username,
	                                      @Value("${spring.datasource.password}") String password ,
	                                      Filter ... filters)  {
		   
		   DruidDataSource druidDataSource = new DruidDataSource();
	        druidDataSource.setDriverClassName(driver);
	        druidDataSource.setUrl(url);
	        druidDataSource.setUsername(username);
	        druidDataSource.setPassword(password);
	        druidDataSource.setValidationQuery("select 1");
	        druidDataSource.setLogAbandoned(true);
	        druidDataSource.setTestWhileIdle(true);
	        druidDataSource.setMinIdle(5);
	        
	        if(filters!=null&&filters.length>0){
	        	   druidDataSource.setProxyFilters(Arrays.asList(filters));
	           }
	        return druidDataSource;
	    }
	
	
    @Bean
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean reg = new ServletRegistrationBean();
        reg.setServlet(new StatViewServlet());
        reg.addUrlMappings("/druid/*");
        //reg.addInitParameter("allow", "127.0.0.1");
        //reg.addInitParameter("deny","");
        reg.addInitParameter("loginUsername", "midai");
        reg.addInitParameter("loginPassword", "midai");
        return reg;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
}

