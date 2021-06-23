package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;

import lombok.Data;


@Data
public class EmployeePayrollData {

	private int empId;
	private String name;
	private long salary;

	public EmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
		super();
		this.empId = empId;
		this.name = employeePayrollDTO.getName();
		this.salary = employeePayrollDTO.getSalary();

	}
	
}
