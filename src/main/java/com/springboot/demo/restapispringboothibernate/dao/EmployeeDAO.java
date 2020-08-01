package com.springboot.demo.restapispringboothibernate.dao;

import java.util.List;

import com.springboot.demo.restapispringboothibernate.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> getEmployyes();
	
	public Employee getSingleEmployee(int id);
	
	public void saveEmployee(Employee employee);
	
	public void delete(int id);
}
