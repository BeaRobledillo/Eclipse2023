package com.example.APIProduct.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.APIProduct.model.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{

}
