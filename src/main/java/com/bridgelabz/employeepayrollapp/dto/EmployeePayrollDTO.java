package com.bridgelabz.employeepayrollapp.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class EmployeePayrollDTO {

	@Pattern(regexp = "^[A-Z]{1}[A-Za-z//s]{2,}$", message = "Employee name Invalid")
	public String name;

	@Min(value = 500, message = "Minimum wage should be more than 500")
	public long salary;

	@Pattern(regexp = "male|female",message="Gender should be male or female")
	public String gender;

	@JsonFormat(pattern = "dd MMM yyyy")
	@NotBlank(message = "Date should not be not empty")
	public LocalDate startDate;

	@NotBlank(message = "Note should not be not empty")
	public String note;

	@NotBlank(message = "profile pic should not be not empty")
	public String profilePic;

	@NotBlank(message = "department feild should not be not empty")
	public List<String> department;

}
