package com.training.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.training.service.DepartmentService;
import com.training.vo.DepartmentVO;

public class DepartmentControllerTest {
	
    @InjectMocks
    private DepartmentController controller;
    
    @Mock
    private DepartmentService service;
    
    @Mock
	ObjectMapper objectMapper;
    
    
    @Before
 	public void initSetupMock() {
		MockitoAnnotations.initMocks(this);
		ObjectWriter objectWriter = new ObjectMapper().writerWithDefaultPrettyPrinter();
		Mockito.when(objectMapper.writerWithDefaultPrettyPrinter()).thenReturn(objectWriter);
 	}
    
    @Test
    public void createDepartmentTest() throws Exception {    
    	

    	ObjectMapper mapper =  new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    	DepartmentVO newDepartment = mapper.readValue(DepartmentControllerTest.class.getClassLoader().getResourceAsStream("create_request.json"), DepartmentVO.class);; 
		assertNotNull(newDepartment);
		
		DepartmentVO mockResponse = new DepartmentVO();
		
		Mockito.when(service.createDepartment(any())).thenReturn(mockResponse);
		
		ResponseEntity<DepartmentVO> response = controller.createDepartment(newDepartment);
		assertNotNull(response.getBody());
		
    }


}
