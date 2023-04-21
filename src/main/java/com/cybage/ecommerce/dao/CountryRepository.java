package com.cybage.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.cybage.ecommerce.entity.Country;



@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "countries", path="countries")
public interface CountryRepository  extends JpaRepository<Country, Integer> {

}
