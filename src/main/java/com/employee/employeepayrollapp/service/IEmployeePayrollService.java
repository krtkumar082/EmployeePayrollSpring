package com.employee.employeepayrollapp.service;

import java.util.List;

import com.employee.employeepayrollapp.dto.EmployeePayrollDTO;
import com.employee.employeepayrollapp.model.EmployeePayrollData;

public interface IEmployeePayrollService {
	List<EmployeePayrollData> getEmployeePayrollData();

	EmployeePayrollData getEmployeePayrollDataById(int empId);

	EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO);
	
	List<EmployeePayrollData> getEmployeePayrollDataByDepartment(String department);

	EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO);

	void deleteEmployeePayrollData(int empId);
}
