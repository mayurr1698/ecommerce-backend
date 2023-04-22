package com.cybage.ecommerce.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//mappings for @restcontroller
@Configuration
public class MyAppConfig implements WebMvcConfigurer {
	
	@Value("${spring.data.rest.base-path}")
	private String basePath;
	
	@Value("${allowed.origin}")
	private String[] allowedOrigins;
	
	//cors maooings
	@Override
	public void addCorsMappings(CorsRegistry cors) {
		cors.addMapping(basePath+"/**").allowedOrigins(allowedOrigins);
	}

}
