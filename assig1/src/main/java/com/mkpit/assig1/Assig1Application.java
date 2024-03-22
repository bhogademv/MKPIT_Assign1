package com.mkpit.assig1;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class Assig1Application {

	public static void main(String[] args) {
		SpringApplication.run(Assig1Application.class, args);
	}
	
	@Configuration
	public class AppConfig {

	    @Bean
	    public ModelMapper modelMapper() {
	        return new ModelMapper();
	    }
	}
}
