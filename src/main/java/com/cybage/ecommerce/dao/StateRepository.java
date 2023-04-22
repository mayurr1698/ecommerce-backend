package com.cybage.ecommerce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.cybage.ecommerce.entity.State;

//@CrossOrigin
@RepositoryRestResource(exported = true) //default value is true
public interface StateRepository extends JpaRepository<State, Integer>{
	
	List<State> findByCountryCode(@Param("code") String code);

}
