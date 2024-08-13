package com.example.demo.controller;

import com.example.demo.JWT.CustomUserDetailsService;
import com.example.demo.JWT.JwtRepository;
import com.example.demo.JWT.JwtResponse;
import com.example.demo.JWT.JwtUtil;
import com.example.demo.model.CustomerMaster;
import com.example.demo.service.CustomerMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/customers")
public class CustomerMasterController {

    private final CustomerMasterService customerMasterService;
    
    @Autowired
	private JwtUtil jwtutil;

	@Autowired
	private JwtRepository repository;

	@Autowired
	private CustomUserDetailsService customuserdetailsservice;

    @Autowired
    public CustomerMasterController(CustomerMasterService customerMasterService) {
        this.customerMasterService = customerMasterService;
    }

    @GetMapping
    public List<CustomerMaster> getAllCustomers() {
        return customerMasterService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerMaster> getCustomerById(@PathVariable int id) {
        Optional<CustomerMaster> customerMaster = customerMasterService.findById(id);
        return customerMaster.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public CustomerMaster createCustomer(@RequestBody CustomerMaster customerMaster) {
        return customerMasterService.save(customerMaster);
    }

//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody CustomerMaster loginRequest) {
//        String email = loginRequest.getCustomerEmail();
//        String password = loginRequest.getCustomerPassword();
//
//        boolean isValid = customerMasterService.validateCustomer(email, password);
//        if (isValid) {
//            // Generate a token or session if needed
//            String token = "bookwormMarch2024"; // Replace with actual token generation if necessary
//            return ResponseEntity.ok(new LoginResponse("Login successful", token));
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
//        }
//    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerMaster> updateCustomer(
            @PathVariable int id,
            @RequestBody CustomerMaster customerMaster) {
        if (!customerMasterService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        customerMaster.setCustomerId(id);
        return ResponseEntity.ok(customerMasterService.save(customerMaster));
    }

    @PutMapping("/{customerId}/{libraryId}")
    public ResponseEntity<String> updateLibraryId(@PathVariable Long customerId, @PathVariable Long libraryId) {
        boolean isUpdated = customerMasterService.updateLibraryId(customerId, libraryId);

        if (isUpdated) {
            return ResponseEntity.ok("Library ID updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found.");
        }
    }
    
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable int id) {
        if (!customerMasterService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        customerMasterService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    @PostMapping("/signup")
    public ResponseEntity<CustomerMaster> signup(@RequestBody CustomerMaster user) {
    	System.out.print(user.getCustomerPassword());
        return ResponseEntity.ok(customerMasterService.signup(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody CustomerMaster user) {
        try {
            String customerEmail = user.getCustomerEmail();
            String customerPassword = user.getCustomerPassword();

            // Authenticate the user
            CustomerMaster authenticatedUser = customerMasterService.login(customerEmail, customerPassword);
            if (authenticatedUser == null) {
                throw new UsernameNotFoundException("Invalid credentials");
            }
            System.out.println(authenticatedUser.getCustomerEmail());

            // Check if the credentials are valid
            boolean result = repository.findUser(user);
            if (!result) {
                throw new UsernameNotFoundException("Credentials don't match");
            }

            // Set the password for CustomUserDetailsService
            customuserdetailsservice.setPassword(authenticatedUser.getCustomerPassword());

            // Load user details for generating JWT token
            UserDetails userdetails = customuserdetailsservice.loadUserByUsername(authenticatedUser.getCustomerEmail());

            // Generate the JWT token
            String token = jwtutil.generateToken(userdetails);
            System.out.println("JWT " + token);

            // Return the JWT token in the response
            return ResponseEntity.ok(new JwtResponse(token,authenticatedUser));

        } catch (UsernameNotFoundException ex) {
            // Handle invalid credentials case
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        } catch (Exception ex) {
            ex.printStackTrace();
            // Handle other exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }

    }

//    public static class LoginResponse {
//        private String message;
//        private String token;
//
//        public LoginResponse(String message, String token) {
//            this.message = message;
//            this.token = token;
//        }
//
//        public String getMessage() {
//            return message;
//        }
//
//        public void setMessage(String message) {
//            this.message = message;
//        }
//
//        public String getToken() {
//            return token;
//        }
//
//        public void setToken(String token) {
//            this.token = token;
//        }
//    }
}
