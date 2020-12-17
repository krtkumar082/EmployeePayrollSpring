package com.employee.employeepayrollapp.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.employeepayrollapp.dto.EmployeePayrollDTO;
import com.employee.employeepayrollapp.exceptions.EmployeePayrollException;
import com.employee.employeepayrollapp.model.EmployeePayrollData;
import com.employee.employeepayrollapp.repository.EmployeePayrollRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService{
	
    
	@Autowired
	private EmployeePayrollRepository employeePayrollRepository;
	
	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		return employeePayrollRepository.findAll();
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int empId) {
		return employeePayrollRepository.findById(empId)
				                   .orElseThrow(()-> new EmployeePayrollException("Employee with employee id "+empId+" does not exist"));
	}

	@Override
	public List<EmployeePayrollData> getEmployeePayrollDataByDepartment(String department) {
	    return 	employeePayrollRepository.findEmployeesByDepatment(department);
	}
	
	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData = null;
		empData = new EmployeePayrollData(empPayrollDTO);
		log.debug("EmployeeData"+empData.toString());
		return employeePayrollRepository.save(empData);
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
		empData.updateEmployeePayrollData(empPayrollDTO);
		return employeePayrollRepository.save(empData);
	}

	@Override
	public void deleteEmployeePayrollData(int empId) {
		EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
	     employeePayrollRepository.delete(empData);

	}

	
}
