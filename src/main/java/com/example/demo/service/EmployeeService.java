package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Employee;

public interface EmployeeService {
	public List<Employee> getAllEmployees();
	public Employee createEmployee(Employee employee);
	public Employee getEmployeeById(Long employeeId);
	public Employee updateEmployee(Long employeeId,Employee employeeDetails);
	public Employee deleteEmployee(Long employeeId);
}
