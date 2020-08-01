package com.springboot.demo.restapispringboothibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.demo.restapispringboothibernate.dao.EmployeeDAO;
import com.springboot.demo.restapispringboothibernate.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	// inject dependency for DAO layer
	@Autowired
	private EmployeeDAO employeeDAO;  						
	
	
	@Override
	@Transactional
	public List<Employee> getEmployyes() {
		return employeeDAO.getEmployyes();						// delegate call to DAO layer
	}

	@Override
	@Transactional
	public Employee getSingleEmployee(int id) {
		return employeeDAO.getSingleEmployee(id);			   // delegate call to DAO layer
	}

	@Override
	@Transactional
	public void saveEmployee(Employee employee) {
		employeeDAO.saveEmployee(employee);					   // delegate call to DAO layer
	}

	@Override
	@Transactional
	public void delete(int id) {
		employeeDAO.delete(id);								   // delegate call to DAO layer
	}

}
