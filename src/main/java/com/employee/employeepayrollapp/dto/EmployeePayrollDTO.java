package com.employee.employeepayrollapp.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

public class EmployeePayrollDTO {
	@Pattern(regexp="^[A-Z]{1}[a-zA-Z]{2,}$",message="Employee Name Invalid")
	public String name;
	@Min(value=500,message="Employee Wage should be more than 500")
	public long salary;

	public EmployeePayrollDTO(String name,long salary) {
		this.name=name;
		this.salary=salary;
	}
	public String toString() {
		return "Name= "+name+" Salary= "+salary;
	}
}
