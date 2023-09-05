package com.mth.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.mth.spring.jdbc.model.Employee;

public class EmployeeDAOJDBCTemplateImpl implements EmployeeDAO {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void save(Employee employee) {
		String query =  "insert into Employee (id, first_name, last_name, salary) values (?,?,?,?)";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		Object[] args = new Object[] {employee.getId(), employee.getFirst_name(), employee.getLast_name(), employee.getSalary()};
		
		int out = jdbcTemplate.update(query, args);
		
		if(out !=0){
			System.out.println("Employee saved with id="+employee.getId());
		}else System.out.println("Employee save failed with id="+employee.getId());
	}

	@Override
	public Employee getById(int id) {
		String query = "select * from Employee where id = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		//using RowMapper anonymous class, we can create a separate RowMapper for reuse
		Employee emp = jdbcTemplate.queryForObject(query, new Object[]{id}, new RowMapper<Employee>(){

			@Override
			public Employee mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Employee emp = new Employee();
				emp.setId(rs.getInt("id"));
				emp.setFirst_name(rs.getString("first_name"));
				emp.setLast_name(rs.getString("last_name"));
				emp.setSalary(rs.getInt("salary"));
				return emp;
			}});
		
		return emp;
	}

	@Override
	public void update(Employee employee) {
		String query = "update Employee set first_name=?, last_name=?, salary=? where id=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Object[] args = new Object[] {employee.getFirst_name(),employee.getLast_name(), employee.getSalary(), employee.getId()};
		
		int out = jdbcTemplate.update(query, args);
		if(out !=0){
			System.out.println("Employee updated with id="+employee.getId());
		}else System.out.println("No Employee found with id="+employee.getId());
	}

	@Override
	public void deleteById(int id) {

		String query = "delete from Employee where id=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		int out = jdbcTemplate.update(query, id);
		if(out !=0){
			System.out.println("Employee deleted with id="+id);
		}else System.out.println("No Employee found with id="+id);
	}


	@Override
	public List<Employee> getAll() {
		String query = "select * from Employee";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Employee> empList = new ArrayList<Employee>();

		List<Map<String,Object>> empRows = jdbcTemplate.queryForList(query);
		
		for(Map<String,Object> empRow : empRows){
			Employee emp = new Employee();
			emp.setId(Integer.parseInt(String.valueOf(empRow.get("id"))));
			emp.setFirst_name(String.valueOf(empRow.get("first_name")));
			emp.setLast_name(String.valueOf(empRow.get("last_name")));
			emp.setSalary(Integer.parseInt(String.valueOf(empRow.get("salary"))));
			empList.add(emp);
		}
		return empList;
	}

}
