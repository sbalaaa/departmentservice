package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeRepository;
import com.example.demo.entities.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees;
	}

	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(Long employeeId) {
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		return employee.get();
	}

	@Override
	public Employee updateEmployee(Long employeeId,Employee employeeDetails) {
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		Employee updateEmployee = new Employee();
		if(employee.get() != null) {
	    	updateEmployee = employee.get();
	    	updateEmployee.setFirstName(employeeDetails.getFirstName());
	    	updateEmployee = employeeRepository.save(updateEmployee);
	    }
		return updateEmployee;
	}

	@Override
	public Employee deleteEmployee(Long employeeId) {
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		if(employee.get() != null) {
			 employeeRepository.delete(employee.get());
	    }
		return employee.get();
	}
	
	
}
