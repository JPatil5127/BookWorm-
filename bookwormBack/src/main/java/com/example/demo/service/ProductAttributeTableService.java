package com.example.demo.service;

import com.example.demo.model.ProductAttributeTable;
import com.example.demo.repository.ProductAttributeTableRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductAttributeTableService {

    private final ProductAttributeTableRepository productAttributeTableRepository;

    @Autowired
    public ProductAttributeTableService(ProductAttributeTableRepository productAttributeTableRepository) {
        this.productAttributeTableRepository = productAttributeTableRepository;
    }

    public List<ProductAttributeTable> findAll() {
        return productAttributeTableRepository.findAll();
    }

    public Optional<ProductAttributeTable> findById(int id) {
        return productAttributeTableRepository.findById(id);
    }

    public ProductAttributeTable save(ProductAttributeTable productAttributeTable) {
        return productAttributeTableRepository.save(productAttributeTable);
    }

    public void delete(int id) {
        productAttributeTableRepository.deleteById(id);
    }
}
