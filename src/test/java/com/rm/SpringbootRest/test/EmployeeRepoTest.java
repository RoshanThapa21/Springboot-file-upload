package com.rm.SpringbootRest.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.rm.SpringbootRest.model.Employee;
import com.rm.SpringbootRest.repo.EmployeeRepo;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepoTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private EmployeeRepo employeeRepo;

	@Test
	public void whenFindByName_thenReturnEmployee() {
		// given
		Employee emp = new Employee("Hello Roshan");
		entityManager.persist(emp);
		entityManager.flush();

		// when
		Employee found = employeeRepo.findByName(emp.getName());

		// then
		assertThat(found.getName()).isEqualTo(emp.getName());
	}
}
