package com.example;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class,DataSourceAutoConfiguration.class})
@ImportResource("classpath*:META-INF/spring/*.xml")
public class ServerRunner {
	public static void main(String[] args) {
		SpringApplication.run(ServerRunner.class, args);
	}
}
