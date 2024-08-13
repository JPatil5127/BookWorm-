package com.example.demo.service;

import com.example.demo.model.RoyaltyCalculationTable;
import com.example.demo.repository.RoyaltyCalculationTableRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoyaltyCalculationTableService {

    private final RoyaltyCalculationTableRepository royaltyCalculationTableRepository;

    @Autowired
    public RoyaltyCalculationTableService(RoyaltyCalculationTableRepository royaltyCalculationTableRepository) {
        this.royaltyCalculationTableRepository = royaltyCalculationTableRepository;
    }

    public List<RoyaltyCalculationTable> findAll() {
        return royaltyCalculationTableRepository.findAll();
    }

    public Optional<RoyaltyCalculationTable> findById(int id) {
        return royaltyCalculationTableRepository.findById(id);
    }

    public RoyaltyCalculationTable save(RoyaltyCalculationTable royaltyCalculationTable) {
        return royaltyCalculationTableRepository.save(royaltyCalculationTable);
    }

    public void delete(int id) {
        royaltyCalculationTableRepository.deleteById(id);
    }
}
