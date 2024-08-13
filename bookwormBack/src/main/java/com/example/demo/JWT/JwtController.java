//package com.example.demo.JWT;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.demo.model.CustomerMaster;
//
//@RestController
//public class JwtController
//{
//
//	@Autowired
//	private JwtUtil jwtutil;
//
//	@Autowired
//	private JwtRepository repository;
//
//	@Autowired
//	private CustomUserDetailsService customuserdetailsservice;
//
//	@PostMapping("/public/token")
//	public ResponseEntity<?> generateToken(@RequestBody CustomerMaster myuser)
//	{
//		try
//		{
//		System.out.println("inside token method");
//		System.out.println(myuser);
//		boolean result=repository.findUser(myuser);
//		if(!result)
//		{
//			throw new UsernameNotFoundException("credentials don't match");
//		}
//		customuserdetailsservice.setPassword(myuser.getCustomerPassword());
//		UserDetails userdetails=customuserdetailsservice.loadUserByUsername(myuser.getCustomerEmail());
//		String token=this.jwtutil.generateToken(userdetails);
//		System.out.println("JWT "+token);
//		return ResponseEntity.ok(new JwtResponse(token));
//		}
//		catch(Exception ee)
//		{
//			ee.printStackTrace();
//			return null;
//		}
//	}
//}
