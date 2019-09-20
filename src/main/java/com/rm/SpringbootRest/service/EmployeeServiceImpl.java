package com.rm.SpringbootRest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rm.SpringbootRest.model.Employee;
import com.rm.SpringbootRest.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepo employeerepo;

	/* SAVE LIST OF EMPLOYEE */

	public List<Employee> saveAll(List<Employee> emp) {
		return employeerepo.saveAll(emp);
	}

	/* FIND ALL EMPLOYEE */

	public List<Employee> findALL() {
		return employeerepo.findAll();
	}

	/* DELETE EMPLOYEE */
	public void delete(Long empid) {
		employeerepo.deleteById(empid);
	}

	public Optional<Employee> findById(Long empid) {
		return employeerepo.findById(empid);

	}

	public Employee findEmployee(Employee emp) {
		return employeerepo.save(emp);
	}

	public void save(Employee emp) {
		employeerepo.save(emp);

	}

	public List<Employee> getAllEmployees() {
		return employeerepo.findAll();
	}

	@Override
	public Employee findByName(String name) {
		
		return employeerepo.findByName(name);
	}

}
