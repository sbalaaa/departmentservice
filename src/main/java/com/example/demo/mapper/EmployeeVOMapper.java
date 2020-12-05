package com.example.demo.mapper;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.example.demo.entities.Employee;
import com.example.demo.vo.EmployeeVO;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.ConverterFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

@Component("employeeDataMapper")
@Primary
public class EmployeeVOMapper extends ConfigurableMapper {

	protected void configure(MapperFactory factory) {
		ConverterFactory converterFactory = factory.getConverterFactory();
		converterFactory.registerConverter("refDepartmentDataConverter", new DepartmentVOConverter());
		factory.classMap(Employee.class, EmployeeVO.class)
        		.field("employeeId", "employeeId")
        		.field("firstName", "firstName")
                .field("lastName", "lastName")
                .field("email", "email")
                .field("phoneNumber", "phoneNumber")
                .field("hireDate", "hireDate")
                .field("salary", "salary")
                .fieldMap("departmentId","departmentId").converter("refDepartmentDataConverter")
                .add()
                .register();
    }
}
