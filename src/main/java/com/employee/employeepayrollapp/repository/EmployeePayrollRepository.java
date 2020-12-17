package com.employee.employeepayrollapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.employeepayrollapp.model.EmployeePayrollData;

public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData,Integer>{

}
