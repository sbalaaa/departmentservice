package com.example.demo.mapper;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;




import com.example.demo.entities.Department;
import com.example.demo.vo.DepartmentVO;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

@Component("departmentDataMapper")
@Primary
public class DepartmentMapper extends ConfigurableMapper {

	protected void configure(MapperFactory factory) {
        factory.classMap(DepartmentVO.class, Department.class)
                .field("number", "number")
                .field("name", "name")
                .register();
    }
}
