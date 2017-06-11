package com.example.config;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.stereotype.Component;

/**
 * 
 * ClassName: PropertiesConfig <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2017年6月11日 下午5:49:07 <br/>
 *
 * @author 屈志刚  598700560@qq.com
 * @version 
 * @since JDK 1.7
 */
@Component
public class PropertiesConfig  implements EnvironmentAware{
	
	private Environment env;

	@Override
	public void setEnvironment(Environment env) {
		this.env=env;	
		StandardEnvironment sse=(StandardEnvironment)env;
		Iterator<PropertySource<?>> it= sse.getPropertySources().iterator();
		while(it.hasNext()){
			PropertySource ps=it.next();
			if(ps instanceof PropertiesPropertySource){
				PropertiesPropertySource pps=(PropertiesPropertySource) ps;
				Map<String, Object> map=pps.getSource();
				properties=new Properties();
				properties.putAll(map);
				break;
			}
		}

		
	}
	
	private Properties properties;
	
	public Properties getProperties(){
		
		return properties;
		
	} 
	
	
	
	
	

}
