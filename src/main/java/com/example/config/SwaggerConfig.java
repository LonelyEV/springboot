package com.example.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * ClassName: SwaggerConfig <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2017年6月11日 下午5:46:10 <br/>
 *
 * @author 屈志刚  598700560@qq.com
 * @version 
 * @since JDK 1.7
 */
@Configuration
@EnableSwagger2
@ComponentScan("com.example.springboot.controller")
public class SwaggerConfig {

    @Bean(name="springbootApi")
    public Docket springbootApi() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.groupName("springbootApi")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.springboot.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    
    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfoBuilder().title("com.example.springboot API")
                .description("The APIs here demonstrate creating a service built with Spring Boot")
                .license("MIT")
                .licenseUrl("http://opensource.org/licenses/MIT")
                .contact(new Contact("springboot", "www.quzhigang.com", "598700560@qq.com"))
                .version("1.0")
                .build();
        return apiInfo;
    }
}
