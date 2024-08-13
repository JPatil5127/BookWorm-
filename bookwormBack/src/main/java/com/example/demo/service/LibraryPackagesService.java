package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.LibraryPackages;
import com.example.demo.repository.LibraryPackagesRepository;

@Service
public class LibraryPackagesService {
	  private final LibraryPackagesRepository libraryPackageRepository;
    @Autowired
    public LibraryPackagesService(LibraryPackagesRepository libraryPackageRepository) {
        this.libraryPackageRepository = libraryPackageRepository;
    }

    public List<LibraryPackages> getAllPackages() {
        return libraryPackageRepository.findAll();
    }

    public Optional<LibraryPackages> getPackageById(Long id) {
        return libraryPackageRepository.findById(id);
    }

    public LibraryPackages createPackage(LibraryPackages libraryPackage) {
        return libraryPackageRepository.save(libraryPackage);
    }

    public LibraryPackages updatePackage(LibraryPackages libraryPackage) {
        return libraryPackageRepository.save(libraryPackage);
    }

    public void deletePackage(Long id) {
        libraryPackageRepository.deleteById(id);
    }
}