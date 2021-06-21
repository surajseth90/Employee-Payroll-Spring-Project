package com.bridgelabz.employeepayrollapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

@RestController
@RequestMapping("/employeepayroll")
public class EmployeePayrollController {

	@RequestMapping(value = { "", "/", "get" })
	public ResponseEntity<ResponseDTO> getEmpPayrollData() {
		EmployeePayrollData employeePayrollData = null;
		employeePayrollData = new EmployeePayrollData(1, new EmployeePayrollDTO("Suraj", 400000));
		ResponseDTO dto = new ResponseDTO("Get Call Successfull", employeePayrollData);
		return new ResponseEntity<ResponseDTO>(dto, HttpStatus.OK);
	}

	@GetMapping("/get/{empId}")
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId) {
		EmployeePayrollData employeePayrollData = null;
		employeePayrollData = new EmployeePayrollData(1, new EmployeePayrollDTO("Suraj", 400000));
		ResponseDTO dto = new ResponseDTO("Get Call for ID Successfull", employeePayrollData);
		return new ResponseEntity<ResponseDTO>(dto, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData employeePayrollData = null;
		employeePayrollData = new EmployeePayrollData(1, employeePayrollDTO);
		ResponseDTO dto = new ResponseDTO("Post Call Successfull", employeePayrollData);
		return new ResponseEntity<ResponseDTO>(dto, HttpStatus.OK);
	}

	@PutMapping("/update/{empId}")
	public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empId") int empId,
			@RequestBody EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData employeePayrollData = null;
		employeePayrollData = new EmployeePayrollData(empId, employeePayrollDTO);
		ResponseDTO dto = new ResponseDTO("update Call Successfull", employeePayrollData);
		return new ResponseEntity<ResponseDTO>(dto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable("empId") int empId) {
		ResponseDTO dto = new ResponseDTO("Delete Call Successfull", empId);
		return new ResponseEntity<ResponseDTO>(dto, HttpStatus.OK);
	}
}
