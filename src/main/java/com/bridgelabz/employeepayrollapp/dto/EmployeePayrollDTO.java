package com.bridgelabz.employeepayrollapp.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class EmployeePayrollDTO {

	@Pattern(regexp = "^[A-Z]{1}[A-Za-z//s]{2,}$",message = "Employee name Invalid")
	private String name;
	
	@Min(value = 500 ,message = "Minimum wage should be more than 500")
	private long salary;

	public EmployeePayrollDTO() {
		
	}
	
	public EmployeePayrollDTO(String name, long salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
}
