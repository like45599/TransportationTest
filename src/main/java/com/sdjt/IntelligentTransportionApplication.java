package com.sdjt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
public class IntelligentTransportionApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntelligentTransportionApplication.class, args);
	}


}
