package com.example.demo.repository;

import com.example.demo.model.CustomerMaster;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerMasterRepository extends JpaRepository<CustomerMaster, Integer> {
//    @Query(value = "SELECT * FROM customer_master WHERE customer_email = :email AND customer_password = :password", nativeQuery = true)
//    CustomerMaster getUserByEmailAndPassword(String email, String password);
	Optional<CustomerMaster> findByCustomerEmail(String customerEmail);
	
	 @Modifying
	    @Query("UPDATE CustomerMaster c SET c.libraryPackage.id = :libraryId WHERE c.customerId = :customerId")
	    int updateLibraryIdByCustomerId(@Param("customerId") Long customerId, @Param("libraryId") Long libraryId);
}
