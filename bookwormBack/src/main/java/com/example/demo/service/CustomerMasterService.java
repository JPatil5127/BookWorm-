package com.example.demo.service;

import com.example.demo.model.CustomerMaster;
import com.example.demo.model.LibraryPackages;
import com.example.demo.repository.CustomerMasterRepository;
import com.example.demo.repository.LibraryPackagesRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerMasterService {

    private final CustomerMasterRepository customerMasterRepository;
    private final LibraryPackagesRepository libraryPackagesRepository;

    @Autowired
    public CustomerMasterService(CustomerMasterRepository customerMasterRepository,LibraryPackagesRepository libraryPackagesRepository) {
        this.customerMasterRepository = customerMasterRepository;
        this.libraryPackagesRepository = libraryPackagesRepository;
    }

    public List<CustomerMaster> findAll() {
        return customerMasterRepository.findAll();
    }

    public Optional<CustomerMaster> findById(int id) {
        return customerMasterRepository.findById(id);
    }

    public CustomerMaster save(CustomerMaster customerMaster) {
        return customerMasterRepository.save(customerMaster);
    }

    public void delete(int id) {
        customerMasterRepository.deleteById(id);
    }

//    public boolean validateCustomer(String email, String password) {
//        CustomerMaster customer = customerMasterRepository.getUserByEmailAndPassword(email, password);
//        return customer != null;
//    }
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public CustomerMaster signup(CustomerMaster user) {
    	System.out.println(user.getCustomerPassword());
        // Check if user already exists
        if (customerMasterRepository.findByCustomerEmail(user.getCustomerEmail()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }

        // Encrypt the password
        user.setCustomerPassword(passwordEncoder.encode(user.getCustomerPassword()));
        System.out.println(user.getCustomerPassword());

        // Save the user
        return customerMasterRepository.save(user);
    }

    public CustomerMaster login(String customerEmail, String customerPassword) {
    	CustomerMaster user = customerMasterRepository.findByCustomerEmail(customerEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (passwordEncoder.matches(customerPassword, user.getCustomerPassword())) {
            return user;
        } else {
            throw new RuntimeException("Invalid password");
        }
    }
    
    @Transactional
    public boolean updateLibraryId(Long customerId, Long libraryId) {
        int updatedRows = customerMasterRepository.updateLibraryIdByCustomerId(customerId, libraryId);
        return updatedRows > 0;
    }
    
    public CustomerMaster assignLibraryPackage(int customerId, Long packageId) {
        CustomerMaster customer = customerMasterRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        LibraryPackages libraryPackage = libraryPackagesRepository.findById(packageId)
                .orElseThrow(() -> new RuntimeException("Library package not found"));

        if (customer.getLibraryPackage() != null) {
            throw new RuntimeException("Customer already has a library package assigned");
        }

        customer.setLibraryPackage(libraryPackage);
        return customerMasterRepository.save(customer);
    }
}
