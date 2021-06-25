package com.bridgelabz.employeepayrollapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exceptions.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.exceptions.EmployeePayrollExceptionHandler;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

	private List<EmployeePayrollData> employeePayrolllist = new ArrayList<>();

	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		return employeePayrolllist;
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataByID(int id) {
//		return employeePayrolllist.stream().filter(empData->empData.getEmpId()==id).findFirst().orElseThrow();
		return employeePayrolllist.get(id - 1);
	}

	@Override
	public EmployeePayrollData addEmployeePayrollData(EmployeePayrollDTO dto) {
		EmployeePayrollData employeePayrollData = null;
		employeePayrollData = new EmployeePayrollData(employeePayrolllist.size() + 1, dto);
		employeePayrolllist.add(employeePayrollData);
		return employeePayrollData;
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO dto) {
		EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataByID(empId);
		employeePayrollData.setName(dto.getName());
		employeePayrollData.setSalary(dto.getSalary());
		employeePayrolllist.set(empId - 1, employeePayrollData);
		return employeePayrollData;
	}

	@Override
	public void deleteEmployeePayrollData(int empId) {
		employeePayrolllist.remove(empId - 1);

	}

}
