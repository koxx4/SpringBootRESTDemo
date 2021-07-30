package com.koxx4.springbootrestdemo;

import com.koxx4.springbootrestdemo.security.configuration.MainSecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@SpringBootApplication
public class SpringBootRestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run( new Class[]{
				SpringBootRestDemoApplication.class
		}, args);
	}

//	@Bean
//	public UserDetailsManager userDetailsManager(){
//		var userDetailsManager = new InMemoryUserDetailsManager();
//
//		userDetailsManager.createUser(User.withUsername("koxx4")
//				.password("password")
//				.roles("admin")
//				.build());
//
//
//		return userDetailsManager;
//	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder(){
//		return NoOpPasswordEncoder.getInstance();
//	}



}
