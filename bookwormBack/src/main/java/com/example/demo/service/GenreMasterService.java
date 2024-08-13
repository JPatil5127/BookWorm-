package com.example.demo.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.GenreMaster;
import com.example.demo.repository.GenreMasterRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GenreMasterService {

    @Autowired
    private GenreMasterRepository repository;

    public List<GenreMaster> getAllGenres() {
        return repository.findAll();
    }

    public Optional<GenreMaster> getGenreById(int id) {
        return repository.findById(id);
    }

    public GenreMaster saveGenre(GenreMaster genre) {
        return repository.save(genre);
    }

    public void deleteGenre(int id) {
        repository.deleteById(id);
    }
}

