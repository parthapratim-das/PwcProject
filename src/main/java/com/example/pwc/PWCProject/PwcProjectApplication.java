package com.example.pwc.PWCProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PwcProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(PwcProjectApplication.class, args);
		System.out.println("Hello");
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}



