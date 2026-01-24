package com.prasanna.jpa_one_to_many_blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaOneToManyBlogApplication {

	public static void main(String[] args) {

		SpringApplication.run(JpaOneToManyBlogApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
