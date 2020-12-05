package com.example.demo.service;

import java.util.List;

import com.example.demo.vo.DepartmentVO;

public interface DepartmentService {
	public List<DepartmentVO> getAllDepartments();
	public DepartmentVO createDepartment(DepartmentVO department);
	public DepartmentVO getDepartmentById(Long departmentId);
	public DepartmentVO updateDepartment(Long departmentId,DepartmentVO departmentDetails);
	public DepartmentVO deleteDepartment(Long departmentId);
}
