package com.example.demo.service;

import com.example.demo.model.InvoiceDetailTable;
import com.example.demo.repository.InvoiceDetailTableRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceDetailTableService {

    private final InvoiceDetailTableRepository invoiceDetailTableRepository;

    @Autowired
    public InvoiceDetailTableService(InvoiceDetailTableRepository invoiceDetailTableRepository) {
        this.invoiceDetailTableRepository = invoiceDetailTableRepository;
    }

    public List<InvoiceDetailTable> findAll() {
        return invoiceDetailTableRepository.findAll();
    }

    public Optional<InvoiceDetailTable> findById(int id) {
        return invoiceDetailTableRepository.findById(id);
    }

    public InvoiceDetailTable save(InvoiceDetailTable invoiceDetailTable) {
        return invoiceDetailTableRepository.save(invoiceDetailTable);
    }

    public void delete(int id) {
        invoiceDetailTableRepository.deleteById(id);
    }
}
