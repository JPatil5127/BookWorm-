package com.example.demo.service;

import com.example.demo.model.ProductMaster;
import com.example.demo.repository.ProductMasterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductMasterService {

    private final ProductMasterRepository productMasterRepository;

    @Autowired
    public ProductMasterService(ProductMasterRepository productMasterRepository) {
        this.productMasterRepository = productMasterRepository;
    }

    public List<ProductMaster> findAll() {
        return productMasterRepository.findAll();
    }

    public Optional<ProductMaster> findById(int id) {
        return productMasterRepository.findById(id);
    }

    public ProductMaster save(ProductMaster productMaster) {
        return productMasterRepository.save(productMaster);
    }

    public void delete(int id) {
        productMasterRepository.deleteById(id);
    }
}
