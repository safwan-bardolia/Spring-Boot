package com.springboot.demo.restapispringboothibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.demo.restapispringboothibernate.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	// inject EntityManager dependency  (similar to sessionFactory)
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Employee> getEmployyes() {
		
		// get the current Hibernate session
		Session session = entityManager.unwrap(Session.class);
		
		// create a query
		Query<Employee> query = session.createQuery("from Employee", Employee.class);
		
		// execute query & get result list
		List<Employee> employees = query.getResultList();
		
		// return list of employees
		return employees;
	}

	@Override
	public Employee getSingleEmployee(int id) {
		
		// get the current hibernate session
		Session session = entityManager.unwrap(Session.class);
		
		// fetch the employee from DB
		Employee employee = session.get(Employee.class, id);
		
		//return employee
		return employee;
	}

	@Override
	public void saveEmployee(Employee employee) {

		// get the current hibernate session
		Session session = entityManager.unwrap(Session.class);
		
		// persist employee into DB
		session.saveOrUpdate(employee);									// note: if PK of employee is null/empty then insert query will execute otherwise update query executed
	}

	@Override
	public void delete(int id) {
		
		// get the current hibernate session
		Session session = entityManager.unwrap(Session.class);
		
		// create a query
		Query query = session.createQuery("delete from Employee where id="+id);
		
		// execute query
		query.executeUpdate();
	}

}
