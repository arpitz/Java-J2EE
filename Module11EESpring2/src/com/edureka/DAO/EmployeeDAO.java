package com.edureka.DAO;

import java.util.List;

import com.edureka.Model.Employee;

public interface EmployeeDAO {
	public abstract void createEmployee(Employee employee);
	public abstract Employee getEmployeeById(int employeeId);
	public abstract void deleteEmployeeById(int employeeId);
	public abstract void updateEmployeeEmailById(String newEmail,int employeeId);
	public abstract List<Employee> getAllEmployeesDetails();
}
