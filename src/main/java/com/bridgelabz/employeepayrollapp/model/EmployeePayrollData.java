package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;

public class EmployeePayrollData {

	private int empId;
	private String name;
	private long salary;

	public EmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
		super();
		this.empId = empId;
		this.name = employeePayrollDTO.name;
		this.salary = employeePayrollDTO.salary;

	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

}
