package com.example.PrimerSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.PrimerSpringBoot.model.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {

	
	
	
}
