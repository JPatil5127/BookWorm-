package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.LanguageMaster;
import com.example.demo.repository.LanguageMasterRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageMasterService {

    @Autowired
    private LanguageMasterRepository repository;

    public List<LanguageMaster> getAllLanguages() {
        return repository.findAll();
    }

    public Optional<LanguageMaster> getLanguageById(int id) {
        return repository.findById(id);
    }

    public LanguageMaster saveLanguage(LanguageMaster language) {
        return repository.save(language);
    }

    public void deleteLanguage(int id) {
        repository.deleteById(id);
    }
}
