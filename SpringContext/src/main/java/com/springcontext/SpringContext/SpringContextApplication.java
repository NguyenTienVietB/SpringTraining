package com.springcontext.SpringContext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.springcontext.Bean"})
public class SpringContextApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringContextApplication.class, args);
	}

}
