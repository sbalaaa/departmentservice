package com.example.demo.mapper;


import com.example.demo.entities.Department;
import com.example.demo.vo.DepartmentVO;

import ma.glasnost.orika.CustomConverter;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.metadata.Type;

public class DepartmentVOConverter extends CustomConverter<Department,DepartmentVO> {
    @Override
    public DepartmentVO convert(Department departmentData, Type<? extends DepartmentVO> type, MappingContext mappingContext) {
    	DepartmentVO departmentDto = new DepartmentVO();
    	departmentDto.setNumber(departmentData.getNumber());
    	departmentDto.setName(departmentData.getName());
        return departmentDto;
    }
}
