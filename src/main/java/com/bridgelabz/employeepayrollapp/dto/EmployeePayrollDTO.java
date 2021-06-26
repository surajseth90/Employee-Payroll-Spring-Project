package com.bridgelabz.employeepayrollapp.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class EmployeePayrollDTO {

	@Pattern(regexp = "^[A-Z]{1}[A-Za-z//s]{2,}$", message = "Employee name Invalid")
	public String name;

	@Min(value = 500, message = "Minimum wage should be more than 500")
	public long salary;

	public String gender;

	public LocalDate startDate;

	public String note;

	public String profilePic;

	public List<String> department;

}
