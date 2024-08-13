package com.example.demo.service;

import com.example.demo.model.BeneficiaryMaster;
import com.example.demo.repository.BeneficiaryMasterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BeneficiaryMasterService {

    private final BeneficiaryMasterRepository beneficiaryMasterRepository;

    @Autowired
    public BeneficiaryMasterService(BeneficiaryMasterRepository beneficiaryMasterRepository) {
        this.beneficiaryMasterRepository = beneficiaryMasterRepository;
    }

    public List<BeneficiaryMaster> findAll() {
        return beneficiaryMasterRepository.findAll();
    }

    public Optional<BeneficiaryMaster> findById(int id) {
        return beneficiaryMasterRepository.findById(id);
    }

    public BeneficiaryMaster save(BeneficiaryMaster beneficiaryMaster) {
        return beneficiaryMasterRepository.save(beneficiaryMaster);
    }

    public void delete(int id) {
        beneficiaryMasterRepository.deleteById(id);
    }
}
