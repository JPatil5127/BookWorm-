package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ProductMaster;

public interface ProductMasterRepository extends JpaRepository<ProductMaster,Integer> {

}
