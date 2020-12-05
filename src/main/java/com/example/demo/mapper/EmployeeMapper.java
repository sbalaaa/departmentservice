package com.example.demo.mapper;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.example.demo.entities.Employee;
import com.example.demo.vo.EmployeeVO;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.ConverterFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

@Component("employeeMapper")
@Primary
public class EmployeeMapper extends ConfigurableMapper {

	protected void configure(MapperFactory factory) {
		ConverterFactory converterFactory = factory.getConverterFactory();
		converterFactory.registerConverter("refDepartmentConverter", new DepartmentConverter());
		factory.classMap(EmployeeVO.class, Employee.class)
        		.field("employeeId", "employeeId")
        		.field("firstName", "firstName")
                .field("lastName", "lastName")
                .field("email", "email")
                .field("phoneNumber", "phoneNumber")
                .field("hireDate", "hireDate")
                .field("salary", "salary")
                .fieldMap("departmentId","departmentId").converter("refDepartmentConverter")
                .add()
                .register();
    }
}
