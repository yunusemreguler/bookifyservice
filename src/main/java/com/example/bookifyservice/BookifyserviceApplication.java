package com.example.bookifyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class BookifyserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookifyserviceApplication.class, args);
	}

}
