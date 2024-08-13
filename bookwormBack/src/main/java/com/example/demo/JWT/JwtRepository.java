package com.example.demo.JWT;

import com.example.demo.model.CustomerMaster;
import com.example.demo.repository.CustomerMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public class JwtRepository {

	@Autowired
	private CustomerMasterRepository userRepository;
	
	@Autowired
    private BCryptPasswordEncoder passwordEncoder;

	public boolean findUser(CustomerMaster user) {
		// Fetch the user from the database
		String customerEmail = user.getCustomerEmail();
        String customerPassword = user.getCustomerPassword();
        System.out.println(customerPassword);
        Optional<CustomerMaster> foundUser = userRepository.findByCustomerEmail(customerEmail);
        System.out.println(foundUser.get().getCustomerPassword());

		// Check if the user exists and the password matches
		if (foundUser.isPresent() && passwordEncoder.matches(customerPassword, foundUser.get().getCustomerPassword())) {
			System.out.println("User found in the database");
			return true;
		} else {
			System.out.println("User not found in the database");
			return false;
		}
	}
}
