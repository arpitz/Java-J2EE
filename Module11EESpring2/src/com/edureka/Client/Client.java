
package com.edureka.Client;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.edureka.Model.Employee;
import com.edureka.Service.EmployeeService;
import com.edureka.Service.impl.EmployeeServiceImpl;

public class Client {

	public static void main(String[] args) {

		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		EmployeeService employeeService = ctx.getBean("employeeService", EmployeeServiceImpl.class);
		
		
		//insertEmployees(employeeService);
		Employee e = getEmployeeById(employeeService);
		computeNetSalary(e);
		
		ctx.close();
	}

	private static Employee getEmployeeById(EmployeeService employeeService) {
		Employee employee = employeeService.fetchEmployeeById(1);
		return employee;
	}
	
	private static void computeNetSalary(Employee e){
		int gross_salary = e.getBasic() + e.getHra() + e.getDa();
		int tax_deduction = (15 * e.getBasic()) / 100;
		int net_salary = gross_salary - (tax_deduction + e.getDeductions());
		System.out.println("The Net Salary for employee " + e.getName() + " is: " + net_salary);
	}

	private static void insertEmployees(EmployeeService employeeService) {
		Employee e1 = new Employee();
		e1.setName("John Marquee");
		e1.setBasic(5000);
		e1.setHra(150);
		e1.setDa(35);
		e1.setDeductions(100);
		
		employeeService.addEmployee(e1);
		
		Employee e2 = new Employee();
		e2.setName("Benny");
		e2.setBasic(5500);
		e2.setHra(150);
		e2.setDa(35);
		e2.setDeductions(100);
		
		employeeService.addEmployee(e2);
		Employee e3 = new Employee();
		e3.setName("Mark");
		e3.setBasic(6000);
		e3.setHra(150);
		e3.setDa(35);
		e3.setDeductions(100);
		
		employeeService.addEmployee(e3);
		
		Employee e4 = new Employee();
		e4.setName("Sarah");
		e4.setBasic(4500);
		e4.setHra(150);
		e4.setDa(35);
		e4.setDeductions(100);
		
		employeeService.addEmployee(e4);
		Employee e5 = new Employee();
		e5.setName("Kyle");
		e5.setBasic(800);
		e5.setHra(150);
		e5.setDa(35);
		e5.setDeductions(100);
		
		employeeService.addEmployee(e5);
		
		Employee e6 = new Employee();
		e6.setName("Tim ALbert");
		e6.setBasic(5000);
		e6.setHra(150);
		e6.setDa(35);
		e6.setDeductions(100);
		
		employeeService.addEmployee(e6);
		
		Employee e7 = new Employee();
		e7.setName("Noah Ritter");
		e7.setBasic(5000);
		e7.setHra(150);
		e7.setDa(35);
		e7.setDeductions(100);
		
		employeeService.addEmployee(e7);
		
		Employee e8 = new Employee();
		e8.setName("Douglas");
		e8.setBasic(9000);
		e8.setHra(150);
		e8.setDa(35);
		e8.setDeductions(100);
		
		employeeService.addEmployee(e8);
		
		Employee e9 = new Employee();
		e9.setName("Bill Gates");
		e9.setBasic(7800);
		e9.setHra(150);
		e9.setDa(35);
		e9.setDeductions(100);
		
		employeeService.addEmployee(e9);
		
		Employee e10 = new Employee();
		e10.setName("Arpit");
		e10.setBasic(55000);
		e10.setHra(150);
		e10.setDa(35);
		e10.setDeductions(100);
		
		employeeService.addEmployee(e10);
	}

}