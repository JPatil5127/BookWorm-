//package com.example.demo.controller;
//
//
//import com.example.demo.model.CustomerMaster;
//import com.example.demo.service.CustomerMasterService;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@CrossOrigin
//@RequestMapping("/signup")
//public class SignUpController {
//
//    private final CustomerMasterService customerMasterService;
//
//    @Autowired
//    public SignUpController(CustomerMasterService customerMasterService) {
//        this.customerMasterService = customerMasterService;
//    }
//
//    @PostMapping
//    public ResponseEntity<?> signUp(@RequestBody CustomerMaster customerMaster) {
//        try {
//            CustomerMaster newCustomer = customerMasterService.save(customerMaster);
//            return ResponseEntity.ok(newCustomer);
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }
//}
