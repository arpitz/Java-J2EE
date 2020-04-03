package com.edureka.Service;

import java.util.List;

import com.edureka.Model.Employee;

public interface EmployeeService {

	public abstract void addEmployee(Employee employee);
	public abstract Employee fetchEmployeeById(int employeeId);
	public abstract void deleteEmployeeById(int employeeId);
	public abstract void updateEmployeeEmailById(String newEmail,int employeeId);
	public abstract List<Employee> getAllEmployeesInfo();

}