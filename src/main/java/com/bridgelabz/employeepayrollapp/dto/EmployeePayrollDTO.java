package com.bridgelabz.employeepayrollapp.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class EmployeePayrollDTO {

//	@Pattern(regexp = "^[A-Z]{1}[A-Za-z//s]{2,}", message = "Employee name Invalid")
	public String name;

	@Min(value = 500, message = "Minimum wage should be more than 500")
	public long salary;

	@Pattern(regexp = "male|female",message="Gender should be male or female")
	public String gender;

//	@NotBlank(message = "Date should not be empty")
	@JsonFormat(pattern = "dd MMM yyyy")
//	@PastOrPresent(message = "Start Date should not be present date or future date")
	public String startDate;

	@NotBlank(message = "Note should not be empty")
	public String note;

	@NotBlank(message = "profile pic should not be empty")
	public String profilePic;

	@NotEmpty(message = "department field should not be empty")
	public List<String> department;

	public EmployeePayrollDTO(){
		
	}
}


