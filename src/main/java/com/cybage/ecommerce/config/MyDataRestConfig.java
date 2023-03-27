package com.cybage.ecommerce.config;

import org.hibernate.boot.Metadata;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.mapping.HttpMethods;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.cybage.ecommerce.entity.Product;
import com.cybage.ecommerce.entity.ProductCategory;

public class MyDataRestConfig  implements RepositoryRestConfigurer{

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		// TODO Auto-generated method stub
		//RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);
		//disable http methodos for product except get
		HttpMethod[] theUnsupportedAction = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};
		config.getExposureConfiguration()
				.forDomainType(Product.class)
				.withItemExposure((Metadata, httpMethods)-> httpMethods.disable(theUnsupportedAction))
				.withCollectionExposure((Metadata, httpMethods)-> httpMethods.disable(theUnsupportedAction));
	
		//disable http methodos for productCategory except get
		config.getExposureConfiguration()
		.forDomainType(ProductCategory.class)
		.withItemExposure((Metadata, httpMethods)-> httpMethods.disable(theUnsupportedAction))
		.withCollectionExposure((Metadata, httpMethods)-> httpMethods.disable(theUnsupportedAction));

	}

}
