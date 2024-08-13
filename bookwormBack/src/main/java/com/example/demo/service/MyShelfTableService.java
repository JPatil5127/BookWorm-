package com.example.demo.service;

import com.example.demo.model.MyShelfTable;
import com.example.demo.repository.MyShelfTableRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MyShelfTableService {

    private final MyShelfTableRepository myShelfTableRepository;

    @Autowired
    public MyShelfTableService(MyShelfTableRepository myShelfTableRepository) {
        this.myShelfTableRepository = myShelfTableRepository;
    }

    public List<MyShelfTable> findAll() {
        return myShelfTableRepository.findAll();
    }

    public Optional<MyShelfTable> findById(int id) {
        return myShelfTableRepository.findById(id);
    }

    public MyShelfTable save(MyShelfTable myShelfTable) {
        return myShelfTableRepository.save(myShelfTable);
    }

    public void delete(int id) {
        myShelfTableRepository.deleteById(id);
    }
    
    public List<MyShelfTable> findByCustomerId(int customerId) {
        return myShelfTableRepository.findByCustomerCustomerId(customerId);
    }
}
