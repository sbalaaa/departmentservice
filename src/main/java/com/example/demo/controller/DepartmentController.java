package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.DepartmentService;
import com.example.demo.vo.DepartmentVO;
/*
 * http://localhost:8080/api/departments
 * 
 * 
 * 
 * 
 * 
 */


@RestController
@RequestMapping("/api")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    @GetMapping("/departments")
	public List<DepartmentVO> getAllDepartments() {
		System.out.println("Start - getAllDepartments");
		List<DepartmentVO> departments = departmentService.getAllDepartments();
		return departments;
	}
	
    @PostMapping("/departments")
	public DepartmentVO createDepartment(@Validated @RequestBody DepartmentVO department) {
		System.out.println("Start - createDepartment");
		return departmentService.createDepartment(department);
	}
	

    @RequestMapping("/departments/{id}")
	public DepartmentVO getDepartmentById(@PathVariable(value = "id") Long departmentId) {
		System.out.println("Start - getDepartmentById --> " + departmentId);
		DepartmentVO department = departmentService.getDepartmentById(departmentId);
	    return department;
	}
	

    @PutMapping("/departments/{id}")
	public DepartmentVO updateDepartment(@PathVariable(value = "id") Long departmentId, 
	                                       @Validated @RequestBody DepartmentVO departmentDetails) {
		System.out.println("Start - updateDepartment with ID -->" + departmentId);
		DepartmentVO department = departmentService.updateDepartment(departmentId,departmentDetails);
	    return department;
	}
    

    @DeleteMapping("/departments/{id}")
	public DepartmentVO deleteDepartment(@PathVariable(value = "id") Long departmentId) {
		System.out.println("Start - deleteDepartment with ID -->" + departmentId );
		DepartmentVO department = departmentService.deleteDepartment(departmentId);
		return department;
	}

}
