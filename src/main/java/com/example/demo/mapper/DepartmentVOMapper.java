package com.example.demo.mapper;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;




import com.example.demo.entities.Department;
import com.example.demo.vo.DepartmentVO;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

@Component("departmentVOMapper")
@Primary
public class DepartmentVOMapper extends ConfigurableMapper {

	protected void configure(MapperFactory factory) {
        factory.classMap(Department.class, DepartmentVO.class)
                .field("number", "number")
                .field("name", "name")
                .register();
    }
}
