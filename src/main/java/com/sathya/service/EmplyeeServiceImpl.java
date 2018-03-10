package com.sathya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathya.entity.Employee;
import com.sathya.repo.EmployeeRepo;

@Service
public class EmplyeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepo employeeRepo;

	@Override
	public Employee findByName(String name) {

		return employeeRepo.findByName(name);
	}

}
