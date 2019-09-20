package com.rm.SpringbootRest.service;

import java.util.List;
import java.util.Optional;

import com.rm.SpringbootRest.model.Employee;

public interface EmployeeService {

	List<Employee> saveAll(List<Employee> emp);

	List<Employee> findALL();

	Optional<Employee> findById(Long empId);

	void delete(Long empid);

	void save(Employee employee);
	
	public Employee findByName(String name);

}
