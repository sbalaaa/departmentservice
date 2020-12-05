package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Department;
import com.example.demo.entities.Employee;
/*
 * http://localhost:8080/api/departments
 * 
 * 
 * 
 * 
 * 
 */
import com.example.demo.service.EmployeeService;


@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
    @CrossOrigin(origins="*", maxAge = 3600)
    @GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		System.out.println("Start - getAllEmployees");
		List<Employee> employees = employeeService.getAllEmployees();
		return new ResponseEntity(employees, HttpStatus.OK);
	}
	
    @CrossOrigin(origins="*")
    @PostMapping("/employees")
	public Employee createDepartment(@Validated @RequestBody Employee employee) {
		System.out.println("Start - createEmployee");
		return employeeService.createEmployee(employee);
	}
	
    @CrossOrigin(origins="*", maxAge = 3600)
    @RequestMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId) {
		System.out.println("Start - getEmployeeById --> " + employeeId);
		Employee employee = employeeService.getEmployeeById(employeeId);
	    if(employee == null) {
	    	System.out.println("Employee Not Found");
	       return ResponseEntity.notFound().build();
	    } else {
	    	System.out.println("Employee Found Name is:" + employee.getFirstName());
	    }
	    return ResponseEntity.ok(employee);
	}
	
    @CrossOrigin(origins="*", maxAge = 3600)
    @PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId, 
	                                       @Validated @RequestBody Employee employeeDetails) {
		System.out.println("Start - updateEmployee with id--> " + employeeId);
		Employee employee = employeeService.updateEmployee(employeeId,employeeDetails);
	    if(employee == null) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok(employee);
	}
    
    @CrossOrigin(origins="*", maxAge = 3600)
    @DeleteMapping("/employees/{id}")
	public ResponseEntity<Department> deleteDepartment(@PathVariable(value = "id") Long employeeId) {
		System.out.println("Start - deleteEmployee with Id --> " + employeeId );
		Employee employee = employeeService.deleteEmployee(employeeId);
	    if(employee == null) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok().build();
	}

}
