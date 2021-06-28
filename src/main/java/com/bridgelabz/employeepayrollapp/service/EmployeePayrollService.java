package com.bridgelabz.employeepayrollapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.repo.EmployeeRepo;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

	@Autowired
	private EmployeeRepo employeeRepo;
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
		employeePayrollData = new EmployeePayrollData(dto);
		return employeeRepo.save(employeePayrollData);
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
