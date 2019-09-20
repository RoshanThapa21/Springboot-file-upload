package com.rm.SpringbootRest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rm.SpringbootRest.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	public Employee findByName(String name);

	public Employee getEmployeeByName(String name);

}
