package com.quzhigang.support;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class MyPropertiesFactoryBean extends PropertiesFactoryBean {
	
	private Logger logger=LoggerFactory.getLogger(MyPropertiesFactoryBean.class);
	
	private String parentDirectory;
  //	private Resource[] locations;
	@Override
	protected void loadProperties(Properties props) throws IOException {
		
		String home=System.getProperties().getProperty("user.home");
		
		String separator=	System.getProperties().getProperty("file.separator");
		
		if("/".equals(separator)){
			
			File parent;
			if(StringUtils.isBlank(parentDirectory)||"/".equals(parentDirectory)){
				parent=new File(home);
			}
			else{
				parent=new File(home,parentDirectory);
			}
			System.out.println(parent);
			if(parent.exists()&&parent.isDirectory()){
				File[] files=parent.listFiles();
				if(files.length>0){
					//Resource[] list=new Resource[files.length];
					List<Resource> list=new ArrayList<Resource>();
					for(int i=0;i<files.length;i++){
						System.out.println(files[i].getName());
						if(files[i].isFile()&&files[i].getName().endsWith(".properties")){
							list.add(new FileSystemResource(files[i]));
						}
						
					}
					logger.info("config----"+list);
					this.setLocations((Resource[])list.toArray(new Resource[list.size()]));
				}
				
			}
			
			
		}
		
			super.loadProperties(props);
		
		
		//获取当前用户跟目录
		
		
	    
		
	}
	public String getParentDirectory() {
		return parentDirectory;
	}
	public void setParentDirectory(String parentDirectory) {
		this.parentDirectory = parentDirectory;
	};

}
