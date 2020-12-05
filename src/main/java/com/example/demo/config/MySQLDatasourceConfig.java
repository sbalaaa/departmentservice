package com.example.demo.config;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.example.demo.dao.DepartmentRepository;
import com.example.demo.dao.EmployeeRepository;
import com.example.demo.entities.Department;
import com.example.demo.entities.Employee;

@Component
@Profile("mysql")
public class MySQLDatasourceConfig {

	@Autowired
	DepartmentRepository departmentRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@PostConstruct
    public void setup() {
        System.out.println("Setting up datasource for MySQL environment. ");
        List<Department> departments = departmentRepository.findAll();
        if( departments!=null && departments.size() == 0 ) {
        	System.out.println("MySQL DB is initialized first time. ");
        	departmentSetup();
	        employeeSetup();
        } else {
        	System.out.println("MySQL DB is alread initialized. ");
        }
    }
	
	
	
	private void departmentSetup() {
		System.out.println("departmentSetup started");
		Department physics = new Department("Physics");
		Department chemistry = new Department("Chemistry");
		Department maths = new Department("Maths");
		departmentRepository.save(physics);
		departmentRepository.save(chemistry);
		departmentRepository.save(maths);
		System.out.println("departmentSetup completed");
	}
	
	
	private void employeeSetup() {
		System.out.println("employeeSetup started");
		Employee one = new Employee("mysql","db","M",30,"arivu@gmail.com","12431212",LocalDate.of(2006, 01, 06),(double) 10000, new Department(1L));
		employeeRepository.save(one);
		System.out.println("employeeSetup completed");
	}
	
}
