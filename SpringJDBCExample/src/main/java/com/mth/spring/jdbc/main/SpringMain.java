package com.mth.spring.jdbc.main;

import java.util.List;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mth.spring.jdbc.dao.EmployeeDAO;
import com.mth.spring.jdbc.model.Employee;

public class SpringMain {

	public static void main(String[] args) {
		//Get the Spring Context
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		
		//Get the EmployeeDAO Bean
		//EmployeeDAO employeeDAO = ctx.getBean("employeeDAO", EmployeeDAO.class);
		//To use JdbcTemplate
		EmployeeDAO employeeDAO = ctx.getBean("employeeDAOJDBCTemplate", EmployeeDAO.class);
		int id = 0;
		//Run some tests for JDBC CRUD operations
		//Get All
		List<Employee> empList = employeeDAO.getAll();
		System.out.println("Employee list: " + empList);
		//get last employee id
        if (!empList.isEmpty()) {
            Employee lastEmployee = empList.get(empList.size() - 1);
            int lastEmployeeId = lastEmployee.getId();
            id = lastEmployeeId + 1;
        }

		
		Employee emp = new Employee();
		emp.setId(id);
		emp.setFirst_name("mai6");
		emp.setLast_name("thu hien6");
		emp.setSalary(16000);;
		
		//Create
		employeeDAO.save(emp);
		
		//Read
		Employee emp1 = employeeDAO.getById(id);
		System.out.println("Employee Retrieved::"+emp1);
		
		//Update
		emp.setSalary(20000);
		employeeDAO.update(emp);
		
		List<Employee> empList1 = employeeDAO.getAll();
		System.out.println("List after update:" + empList1);
		
		//Delete
		employeeDAO.deleteById(id);
		List<Employee> empList2 = employeeDAO.getAll();
		System.out.println("List after delete:" + empList2);
		//Close Spring Context
		ctx.close();
		
		System.out.println("DONE");
	}

}
