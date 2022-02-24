package com.koxx4.springbootrestdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Koxx4WebApplication {
	public static void main(String[] args) {
		SpringApplication.run( new Class[]{
				Koxx4WebApplication.class
		}, args);
	}
}
