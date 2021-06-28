package com.bridgelabz.employeepayrollapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

public interface EmployeeRepo extends JpaRepository<EmployeePayrollData,Integer> {

}
