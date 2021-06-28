package com.bridgelabz.employeepayrollapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.addressbookapp.exception.AddressBookException;
import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exceptions.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.repo.EmployeeRepo;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		return employeeRepo.findAll();
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataByID(int id) {
		return employeeRepo.findById(id)
						.orElseThrow(() -> new EmployeePayrollException("Emloyee Payroll Book with id = " + id + " is not exists !!"));
	}

	@Override
	public EmployeePayrollData addEmployeePayrollData(EmployeePayrollDTO dto) {
		EmployeePayrollData employeePayrollData = null;
		employeePayrollData = new EmployeePayrollData(dto);
		return employeeRepo.save(employeePayrollData);
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO dto) {
		EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataByID(empId);
		employeePayrollData.updateEmployeePayrollData(dto);
		return employeeRepo.save(employeePayrollData);
	}

	@Override
	public void deleteEmployeePayrollData(int empId) {
		employeeRepo.deleteById(empId);

	}

}
