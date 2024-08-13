package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.LibraryPackages;
import com.example.demo.service.LibraryPackagesService;

@RestController
@RequestMapping("/api/library-packages")
@CrossOrigin
public class LibraryPackagesController {

    private final LibraryPackagesService libraryPackageService;

    @Autowired
    public LibraryPackagesController(LibraryPackagesService libraryPackageService) {
        this.libraryPackageService = libraryPackageService;
    }

    @GetMapping
    public ResponseEntity<List<LibraryPackages>> getAllPackages() {
        List<LibraryPackages> packages = libraryPackageService.getAllPackages();
        return new ResponseEntity<>(packages, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibraryPackages> getPackageById(@PathVariable Long id) {
        return libraryPackageService.getPackageById(id)
                .map(pkg -> new ResponseEntity<>(pkg, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<LibraryPackages> createPackage(@RequestBody LibraryPackages libraryPackage) {
        LibraryPackages createdPackage = libraryPackageService.createPackage(libraryPackage);
        return new ResponseEntity<>(createdPackage, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibraryPackages> updatePackage(@PathVariable Long id, @RequestBody LibraryPackages libraryPackage) {
        return libraryPackageService.getPackageById(id)
                .map(existingPackage -> {
                    libraryPackage.setId(id);
                    LibraryPackages updatedPackage = libraryPackageService.updatePackage(libraryPackage);
                    return new ResponseEntity<>(updatedPackage, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePackage(@PathVariable Long id) {
        return libraryPackageService.getPackageById(id)
                .map(pkg -> {
                    libraryPackageService.deletePackage(id);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}