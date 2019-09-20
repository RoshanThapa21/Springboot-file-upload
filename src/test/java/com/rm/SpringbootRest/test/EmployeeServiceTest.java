package com.rm.SpringbootRest.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.rm.SpringbootRest.model.Employee;
import com.rm.SpringbootRest.repo.EmployeeRepo;
import com.rm.SpringbootRest.service.EmployeeService;
import com.rm.SpringbootRest.service.EmployeeServiceImpl;

@RunWith(SpringRunner.class)
public class EmployeeServiceTest {
   
	@TestConfiguration
	static class EmployeeServiceTestContextConfiguration {

		@Bean
		public EmployeeService employeeService() {
			return new EmployeeServiceImpl();
		}
	}
   
	
	@Autowired
	private EmployeeService employeeService;
	
	@MockBean
	private EmployeeRepo employeeRepo;

	@Before
	public void setUp() {
		Employee emp = new Employee("Hello Reva");

		Mockito.when(employeeRepo.findByName(emp.getName())).thenReturn(emp);
	}

	@Test
	public void whenValidName_thenEmployeeShouldBeFound() {
		String name = "Hello Reva";
		Employee found = employeeService.findByName(name);

		assertThat(found.getName()).isEqualTo(name);

	}
}
