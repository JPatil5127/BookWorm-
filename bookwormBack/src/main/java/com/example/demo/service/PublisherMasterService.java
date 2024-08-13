package com.example.demo.service;

import com.example.demo.model.PublisherMaster;
import com.example.demo.repository.PublisherMasterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherMasterService {

    private final PublisherMasterRepository publisherMasterRepository;

    @Autowired
    public PublisherMasterService(PublisherMasterRepository publisherMasterRepository) {
        this.publisherMasterRepository = publisherMasterRepository;
    }

    public List<PublisherMaster> findAll() {
        return publisherMasterRepository.findAll();
    }

    public Optional<PublisherMaster> findById(int id) {
        return publisherMasterRepository.findById(id);
    }

    public PublisherMaster save(PublisherMaster publisherMaster) {
        return publisherMasterRepository.save(publisherMaster);
    }

    public void delete(int id) {
        publisherMasterRepository.deleteById(id);
    }
}
