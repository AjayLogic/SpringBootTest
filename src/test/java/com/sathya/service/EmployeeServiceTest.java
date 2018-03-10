package com.sathya.service;

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

import com.sathya.entity.Employee;
import com.sathya.repo.EmployeeRepo;

@RunWith(SpringRunner.class)
public class EmployeeServiceTest {

	@TestConfiguration
	static class EmployeeServiceTestConfig {

		@Bean
		public EmployeeService employeeService() {
			return new EmplyeeServiceImpl();
		}
	}

	@Autowired
	EmployeeService employeeService;

	@MockBean
	private EmployeeRepo employeeRepo ;

	@Before
	public void setup() {
		Employee sathya = new Employee("sathya");
		Mockito.when(employeeRepo.findByName("sathya")).thenReturn(sathya);
	}

	@Test
	public void findByNameTest() {

		String name = "sathya";

		Employee found = employeeService.findByName(name);

		assertThat(found.getName()).isEqualTo(name);
	}
}
