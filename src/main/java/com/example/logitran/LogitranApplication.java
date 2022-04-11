package com.example.logitran;

import com.example.logitran.Validation.Validation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
//@ComponentScan(basePackageClasses = {Validation.class})
public class LogitranApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogitranApplication.class, args);
	}

}
