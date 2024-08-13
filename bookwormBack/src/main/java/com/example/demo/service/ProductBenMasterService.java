package com.example.demo.service;

import com.example.demo.model.ProductBenMaster;
import com.example.demo.repository.ProductBenMasterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductBenMasterService {

    private final ProductBenMasterRepository productBenMasterRepository;

    @Autowired
    public ProductBenMasterService(ProductBenMasterRepository productBenMasterRepository) {
        this.productBenMasterRepository = productBenMasterRepository;
    }

    public List<ProductBenMaster> findAll() {
        return productBenMasterRepository.findAll();
    }

    public Optional<ProductBenMaster> findById(int id) {
        return productBenMasterRepository.findById(id);
    }

    public ProductBenMaster save(ProductBenMaster productBenMaster) {
        return productBenMasterRepository.save(productBenMaster);
    }

    public void delete(int id) {
        productBenMasterRepository.deleteById(id);
    }
    
    public ProductBenMaster findByProductId(int id) {
    	return productBenMasterRepository.findByProduct_ProdId(id);
    }
}
