package com.rm.SpringbootRest.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rm.SpringbootRest.exception.EmployeeNotFoundException;
import com.rm.SpringbootRest.model.Employee;
import com.rm.SpringbootRest.repo.EmployeeRepo;
import com.rm.SpringbootRest.service.EmployeeService;
import com.rm.SpringbootRest.service.EmployeeServiceImpl;

//Employee Controller added

@RestController
@RequestMapping("api")
public class EmployeeController {

	@Autowired
	EmployeeService employeeservice;
	
	@GetMapping
	public String returnHello() {
		return "Hello Roshan this is REST api !!!";	
	}

	/* SAVE LIST EMPLOYEE IN DATABASE */
	@PostMapping("/admin/employees/create")
	public List<Employee> createEmployee(@RequestBody List<Employee> emp) {
		return employeeservice.saveAll(emp);
	}

	/* GET ALL EMPLOYEE */
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeservice.findALL();
	}
	
	/* GET EMPLOYEE With ID */
	@GetMapping("/employees/{id}")
	//@PreAuthorize("hasAnyRole('ADMIN')")
	public Optional<Employee> getEmployeeById(@PathVariable(value="id") Long empId) throws EmployeeNotFoundException {
		Optional<Employee> employee = employeeservice.findById(empId);
		if (!employee.isPresent()) {
			 throw new EmployeeNotFoundException("Employee with this id: " + empId + ", is not found");
			 }
		return employeeservice.findById(empId);
			
	}
	
	/* Get Employee by Name */
	@GetMapping("/employees/name")
	public Employee findEmployeeByName(String name) {
		return employeeservice.findByName(name);
		
	}
	
	/* Delete EMPLOYEE by ID */

	@DeleteMapping("/employees/delete/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value = "id") Long empid) {
		employeeservice.delete(empid);

		return ResponseEntity.ok().build();
	} 
	
	/* Update an EMPLOYEE */
	@PutMapping("/employee/update/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable long id) {

		Optional<Employee> empOptional = employeeservice.findById(id);

		if (!empOptional.isPresent())
			return ResponseEntity.notFound().build();

		employee.setId(id);
		
		employeeservice.save(employee);

		return ResponseEntity.noContent().build();
	}
}
