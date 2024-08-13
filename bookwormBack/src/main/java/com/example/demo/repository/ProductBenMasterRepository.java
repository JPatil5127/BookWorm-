package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.ProductBenMaster;

public interface ProductBenMasterRepository extends JpaRepository<ProductBenMaster, Integer>{
	@Query("SELECT p FROM ProductBenMaster p WHERE p.product.id = :productId")
    ProductBenMaster findByProduct_ProdId(@Param("productId") int productId);
}
