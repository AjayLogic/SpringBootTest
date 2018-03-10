package com.sathya.repo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.sathya.entity.Employee;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepoTest {

	@Autowired
	private TestEntityManager testEntityManager;

	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Test
	public void findByNameTest() {
		// given
		Employee sathya = new Employee("Sathya");
		testEntityManager.persist(sathya);
		testEntityManager.flush();

		// when
		Employee found = employeeRepo.findByName(sathya.getName());

		// then
		assertThat(found.getName()).isEqualTo(sathya.getName());

	}
}
