package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ProductAttributeTable;

public interface ProductAttributeTableRepository extends JpaRepository<ProductAttributeTable,Integer> {

}
