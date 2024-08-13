package com.example.demo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.example.demo.JWT.CustomUserDetailsService;
import com.example.demo.JWT.JWTAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
@Configuration
@EnableWebSecurity
public class SecurityConfig 
{
	// Using HttpSecurity we can configure which api can 
	// be accessed by whom, whether we want 'form-based' or 
	// 'basic' authentication
	 @Autowired
	    JWTAuthenticationFilter jwtfilter;

	    @Autowired
	    private CustomUserDetailsService customUserDetailsService;

	    @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        System.out.println("securityFilterChain method");

	        http.csrf(csrf -> csrf.disable())
	            .authorizeHttpRequests(auth -> auth
	                .requestMatchers("/public/**").permitAll()
	                .requestMatchers("/api/products").permitAll()
	                .requestMatchers("/api/products/**").permitAll()
	                .requestMatchers("/api/customers/signup").permitAll()
	                .requestMatchers("/api/customers/login").permitAll()
	                .anyRequest().authenticated()
	            );

	        http.addFilterBefore(jwtfilter, UsernamePasswordAuthenticationFilter.class);
	        http.authenticationProvider(daoAuthenticationProvider());

	        http.cors(cors -> cors.configurationSource(corsConfigurationSource()));

	        DefaultSecurityFilterChain build = http.build();
	        return build;
	    }

	    @Bean
	    public DaoAuthenticationProvider daoAuthenticationProvider() {
	        System.out.println("inside daoAuthenticationProvider method");
	        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
	        provider.setUserDetailsService(customUserDetailsService);
	        return provider;
	    }

	    @Bean
	    public CorsConfigurationSource corsConfigurationSource() {
	        CorsConfiguration configuration = new CorsConfiguration();
	        configuration.setAllowedOriginPatterns(Arrays.asList("*"));
	        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
	        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
	        configuration.setAllowCredentials(true);

	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        source.registerCorsConfiguration("/**", configuration);
	        return source;
	    }
	 @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	
}