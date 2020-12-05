package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DepartmentRepository;
import com.example.demo.entities.Department;
import com.example.demo.mapper.DepartmentMapper;
import com.example.demo.mapper.DepartmentVOMapper;
import com.example.demo.vo.DepartmentVO;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	DepartmentRepository departmentRepository;
	
	@Autowired
	DepartmentMapper departmentMapper; // VO -> Entity
	
	@Autowired
	DepartmentVOMapper departmentVOMapper; // Entity -> VO
	
	@Override
	public List<DepartmentVO> getAllDepartments() {
		List<Department> departments = departmentRepository.findAll();
		List<DepartmentVO> departmentVOList = departments.stream()
                .map(department -> departmentVOMapper.map(department, DepartmentVO.class))
                .collect(Collectors.toList());
		return departmentVOList;
	}

	@Override
	public DepartmentVO createDepartment(DepartmentVO departmentVO) {
		Department department = departmentRepository.save(departmentMapper.map(departmentVO, Department.class));
		return departmentVOMapper.map(department, DepartmentVO.class);
	}

	@Override
	public DepartmentVO getDepartmentById(Long departmentId) {
		Optional<Department> department = departmentRepository.findById(departmentId);
		return departmentVOMapper.map(department.get(), DepartmentVO.class);
	}

	@Override
	public DepartmentVO updateDepartment(Long departmentId,DepartmentVO departmentDetails) {
		Optional<Department> department = departmentRepository.findById(departmentId);
		Department modifiedDepartment = null;
		if(department.get() != null) {
	    	modifiedDepartment = department.get();
	    	modifiedDepartment.setName(departmentDetails.getName());
	    	modifiedDepartment = departmentRepository.save(modifiedDepartment);
	    }
		return departmentVOMapper.map(modifiedDepartment, DepartmentVO.class);
	}

	@Override
	public DepartmentVO deleteDepartment(Long departmentId) {
		Optional<Department> department = departmentRepository.findById(departmentId);
		if(department.get() != null) {
			 departmentRepository.delete(department.get());
	    }
		return departmentVOMapper.map(department.get(), DepartmentVO.class);
	}
	
	
}
