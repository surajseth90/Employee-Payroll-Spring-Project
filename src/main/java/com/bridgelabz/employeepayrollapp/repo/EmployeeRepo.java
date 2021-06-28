package com.bridgelabz.employeepayrollapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

public interface EmployeeRepo extends JpaRepository<EmployeePayrollData,Integer> {
	
	@Query(value = "Select * FROM employee_payroll_data,employee_department WHERE employee_id=id AND department=:department",nativeQuery = true)
	List<EmployeePayrollData> findEmployeeByDepartment(String department);
}
