package com.irfan.springdata.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.irfan.springdata.product.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
