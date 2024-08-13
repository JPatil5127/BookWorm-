package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ProductType;
import com.example.demo.repository.ProductTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductTypeService {

    @Autowired
    private ProductTypeRepository repository;

    public List<ProductType> getAllProductTypes() {
        return repository.findAll();
    }

    public Optional<ProductType> getProductTypeById(int id) {
        return repository.findById(id);
    }

    public ProductType saveProductType(ProductType productType) {
        return repository.save(productType);
    }

    public List<ProductType> saveProductType(List<ProductType> productType) {
        return repository.saveAll(productType);
    }
    public void deleteProductType(int id) {
        repository.deleteById(id);
    }
}

