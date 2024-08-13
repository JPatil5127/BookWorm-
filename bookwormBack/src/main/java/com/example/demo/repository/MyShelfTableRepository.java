package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.MyShelfTable;

public interface MyShelfTableRepository extends JpaRepository<MyShelfTable, Integer>{
	List<MyShelfTable> findByCustomerCustomerId(int customerId);
}
