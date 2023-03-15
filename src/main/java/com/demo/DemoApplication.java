package com.demo;

import com.demo.employee.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class DemoApplication {//implements CommandLineRunner {

//	@Autowired
//	EmployeeDto emp ;
	// made some changes
	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);

	}

//	@Override
//	public void run(String... args) throws Exception {
//
//		System.out.println(emp.getSalary());
//	}
}
