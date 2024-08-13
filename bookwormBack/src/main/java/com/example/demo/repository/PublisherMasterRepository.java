package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.PublisherMaster;

public interface PublisherMasterRepository extends JpaRepository<PublisherMaster, Integer> {

}
