package com.bridgelabz.employeepayrollapp.service;

import java.util.List;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

public interface IEmployeePayrollService {

	List<EmployeePayrollData> getEmployeePayrollData();

	EmployeePayrollData getEmployeePayrollDataByID(int id);

	EmployeePayrollData addEmployeePayrollData(EmployeePayrollDTO dto);

	EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO dto);

	void deleteEmployeePayrollData(int empId);

}
