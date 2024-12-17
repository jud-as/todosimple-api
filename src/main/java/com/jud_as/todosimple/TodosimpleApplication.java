package com.jud_as.todosimple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.jud_as.todosimple")
public class TodosimpleApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodosimpleApplication.class, args);
	}

}
