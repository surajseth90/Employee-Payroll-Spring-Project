package com.bridgelabz.employeepayrollapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		List<EmployeePayrollData> employeePayrollData = new ArrayList<>();
		employeePayrollData.add(new EmployeePayrollData(1, new EmployeePayrollDTO("Suraj", 400000)));
		return employeePayrollData;
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataByID(int id) {
		EmployeePayrollData employeePayrollData = new EmployeePayrollData(1, new EmployeePayrollDTO("Suraj", 400000));
		return employeePayrollData;
	}

	@Override
	public EmployeePayrollData addEmployeePayrollData(EmployeePayrollDTO dto) {
		EmployeePayrollData employeePayrollData = null;
		employeePayrollData = new EmployeePayrollData(1, dto);
		return employeePayrollData;
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO dto) {
		EmployeePayrollData employeePayrollData = null;
		employeePayrollData = new EmployeePayrollData(empId, dto);
		return employeePayrollData;
	}

	@Override
	public void deleteEmployeePayrollData(int empId) {
		// TODO Auto-generated method stub

	}

}
