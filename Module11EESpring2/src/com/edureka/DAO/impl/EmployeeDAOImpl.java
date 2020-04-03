package com.edureka.DAO.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.edureka.DAO.EmployeeDAO;
import com.edureka.Model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void createEmployee(Employee employee) {
		hibernateTemplate.setCheckWriteOperations(false);
		hibernateTemplate.save(employee);
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		Employee employee = hibernateTemplate.get(Employee.class,employeeId);
		return employee;
	}

	@Override
	public void deleteEmployeeById(int employeeId) {
		
	}

	@Override
	public void updateEmployeeEmailById(String newEmail, int employeeId) {
		
	}

	@Override
	public List<Employee> getAllEmployeesDetails() {
		
		DetachedCriteria criteria= DetachedCriteria.forClass(Employee.class);
		List<Employee> EmpList =(List<Employee>) hibernateTemplate.findByCriteria(criteria);
		return EmpList;
	}
	
}
