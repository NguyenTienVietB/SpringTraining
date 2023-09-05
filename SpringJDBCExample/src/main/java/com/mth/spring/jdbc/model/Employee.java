package com.mth.spring.jdbc.model;

public class Employee {

	private int id;
	private String first_name;
	private String last_name;
	private int salary;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	@Override
	public String toString(){
		return "{ID="+id+",First_name="+first_name+",Last_name="+last_name+", Salary = "+salary+"}";
	}
}
