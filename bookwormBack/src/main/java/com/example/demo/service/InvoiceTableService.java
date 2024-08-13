package com.example.demo.service;

import com.example.demo.model.InvoiceTable;
import com.example.demo.repository.InvoiceTableRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceTableService {

    private final InvoiceTableRepository invoiceTableRepository;

    @Autowired
    public InvoiceTableService(InvoiceTableRepository invoiceTableRepository) {
        this.invoiceTableRepository = invoiceTableRepository;
    }

    public List<InvoiceTable> findAll() {
        return invoiceTableRepository.findAll();
    }

    public Optional<InvoiceTable> findById(int id) {
        return invoiceTableRepository.findById(id);
    }

    public InvoiceTable save(InvoiceTable invoiceTable) {
        return invoiceTableRepository.save(invoiceTable);
    }

    public void delete(int id) {
        invoiceTableRepository.deleteById(id);
    }
}
