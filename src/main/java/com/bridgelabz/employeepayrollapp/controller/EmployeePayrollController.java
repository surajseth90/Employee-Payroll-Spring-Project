package com.bridgelabz.employeepayrollapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.bridgelabz.employeepayrollapp.service.IEmployeePayrollService;

@RestController
@RequestMapping("/employeepayroll")
public class EmployeePayrollController {

	@Autowired
	private IEmployeePayrollService employeePayrollService;

	@RequestMapping(value = { "", "/", "get" })
	public ResponseEntity<ResponseDTO> getEmpPayrollData() {
		List<EmployeePayrollData> employeePayrollData = null;
		employeePayrollData = employeePayrollService.getEmployeePayrollData();
		ResponseDTO dto = new ResponseDTO("Get Call Successfull", employeePayrollData);
		return new ResponseEntity<ResponseDTO>(dto, HttpStatus.OK);
	}

	@GetMapping("/get/{empId}")
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId) {
		EmployeePayrollData employeePayrollData = employeePayrollService.getEmployeePayrollDataByID(empId);
		ResponseDTO dto = new ResponseDTO("Get Call for ID Successfull", employeePayrollData);
		return new ResponseEntity<ResponseDTO>(dto, HttpStatus.OK);
	}
	
	@GetMapping("/get/department/{department}")
	public ResponseEntity<ResponseDTO> getEmployeeDepartment(@PathVariable("department") String department) {
		List<EmployeePayrollData> employeePayrollData = null;
		employeePayrollData = employeePayrollService.findEmployeeByDepartment(department);
		ResponseDTO dto = new ResponseDTO("Get Call for ID Successfull", employeePayrollData);
		return new ResponseEntity<ResponseDTO>(dto, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addEmployeePayrollData(@Valid @RequestBody EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData employeePayrollData = employeePayrollService.addEmployeePayrollData(employeePayrollDTO);
		ResponseDTO dto = new ResponseDTO("Post Call Successfull", employeePayrollData);
		return new ResponseEntity<ResponseDTO>(dto, HttpStatus.OK);
	}

	@PutMapping("/update/{empId}")
	public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@Valid @PathVariable("empId") int empId,
			@RequestBody EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData employeePayrollData = employeePayrollService.updateEmployeePayrollData(empId,
				employeePayrollDTO);
		ResponseDTO dto = new ResponseDTO("update Call Successfull", employeePayrollData);
		return new ResponseEntity<ResponseDTO>(dto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable("empId") int empId) {
		employeePayrollService.deleteEmployeePayrollData(empId);
		ResponseDTO dto = new ResponseDTO("Delete Call Successfull", empId);
		return new ResponseEntity<ResponseDTO>(dto, HttpStatus.OK);
	}
}
