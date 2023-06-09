package com.cybage.ecommerce.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.cybage.ecommerce.entity.Product;
import com.cybage.ecommerce.entity.ProductCategory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.Type;

//congid for spring data rest api's

@Configuration
public class MyDataRestConfig  implements RepositoryRestConfigurer{
	@Autowired
	private EntityManager entityManager;
	
	@Value("${allowed.origin}")
	private String[] allowedOrigins;
	

	@Override
    public void configureRepositoryRestConfiguration(
      RepositoryRestConfiguration config, CorsRegistry cors) {
        Class<?>[] classes = entityManager.getMetamodel()
          .getEntities().stream().map(EntityType<?>::getJavaType).toArray(Class[]::new);
        config.exposeIdsFor(classes);
        
        //configure cors mapping
        cors.addMapping(config.getBasePath()+"/**").allowedOrigins(this.allowedOrigins);
    }

	

}
