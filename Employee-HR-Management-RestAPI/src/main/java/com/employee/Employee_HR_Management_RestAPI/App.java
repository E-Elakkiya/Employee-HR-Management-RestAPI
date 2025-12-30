package com.employee.Employee_HR_Management_RestAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.employee.Employee_HR_Management_RestAPI","com.controller","com.model"})
public class App {
    public static void main(String[] args) {
    	 SpringApplication.run(App.class, args);
        
    }
}
