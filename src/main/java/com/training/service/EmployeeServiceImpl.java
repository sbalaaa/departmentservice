package com.training.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.dao.EmployeeRepository;
import com.training.entities.Department;
import com.training.entities.Employee;
import com.training.exceptions.ClientErrorException;
import com.training.vo.EmployeeVO;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	
	@Override
	public List<EmployeeVO> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		List<EmployeeVO> employeeVOList = employees.stream().map(EmployeeVO::new).collect(Collectors.toList());
		return employeeVOList;
	}

	@Override
	public EmployeeVO createEmployee(EmployeeVO employeeVO) {
		Employee createEmployee = employeeVO.getEmployee();
		System.out.println("Deparament of employee is " + createEmployee.getDepartmentId().getDepartmentId());
		Employee employee = employeeRepository.save(createEmployee);
		return employee.getEmployeeVO();
	}

	@Override
	public EmployeeVO getEmployeeById(int employeeId) {
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		try {
			return employee.get().getEmployeeVO();
  		} catch(NoSuchElementException ex) {
  			throw new ClientErrorException("Employee Not Found For ID : " + employeeId);
  		}
	}

	@Override
	public EmployeeVO updateEmployee(int employeeId,EmployeeVO employeeDetails) {
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		Employee updateEmployee = new Employee();
		if(employee.get() != null) {
	    	updateEmployee = employee.get();
	    	updateEmployee.setSalary(employeeDetails.getSalary());
	    	updateEmployee.setAge(employeeDetails.getAge());
	    	
	    	if(employeeDetails.getDepartmentId()!=null) {
	    		Department department = new Department();
	    		department.setDepartmentId(employeeDetails.getDepartmentId().getNumber());
	    		updateEmployee.setDepartmentId(department);
	    	}
	    	updateEmployee = employeeRepository.save(updateEmployee);
	    }
		return updateEmployee.getEmployeeVO();
	}

	@Override
	public EmployeeVO deleteEmployee(int employeeId) {
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		if(employee.get() != null) {
			 employeeRepository.delete(employee.get());
	    }
		return employee.get().getEmployeeVO();
	}
	
	
}
