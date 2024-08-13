package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.InvoiceDetailTable;

public interface InvoiceDetailTableRepository extends JpaRepository<InvoiceDetailTable, Integer>{

}
