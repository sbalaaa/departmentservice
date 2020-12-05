package com.example.demo.mapper;

import com.example.demo.entities.Department;
import com.example.demo.vo.DepartmentVO;

import ma.glasnost.orika.CustomConverter;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.metadata.Type;

public class DepartmentConverter extends CustomConverter<DepartmentVO,Department> {
    @Override
    public Department convert(DepartmentVO departmentData, Type<? extends Department> type, MappingContext mappingContext) {
    	Department departmentDto = new Department();
    	departmentDto.setNumber(departmentData.getNumber());
    	departmentDto.setName(departmentData.getName());
        return departmentDto;
    }
}
