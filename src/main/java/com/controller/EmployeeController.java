package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {

	
	@GetMapping("/newemployee")
	public String newEmployee() {
		System.out.println("......new employee.....");
		return "NewEmployee";
	}
	
	//post mapping 
	//public String saveEmployee(){}
	
}
