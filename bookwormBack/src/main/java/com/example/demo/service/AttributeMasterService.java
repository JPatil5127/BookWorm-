package com.example.demo.service;

import com.example.demo.model.AttributeMaster;
import com.example.demo.repository.AttributeMasterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttributeMasterService {

    private final AttributeMasterRepository attributeMasterRepository;

    @Autowired
    public AttributeMasterService(AttributeMasterRepository attributeMasterRepository) {
        this.attributeMasterRepository = attributeMasterRepository;
    }

    public List<AttributeMaster> findAll() {
        return attributeMasterRepository.findAll();
    }

    public Optional<AttributeMaster> findById(int id) {
        return attributeMasterRepository.findById(id);
    }

    public AttributeMaster save(AttributeMaster attributeMaster) {
        return attributeMasterRepository.save(attributeMaster);
    }

    public void delete(int id) {
        attributeMasterRepository.deleteById(id);
    }
}
