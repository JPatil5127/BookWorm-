package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.InvoiceTable;

public interface InvoiceTableRepository extends JpaRepository<InvoiceTable, Integer> {

}
