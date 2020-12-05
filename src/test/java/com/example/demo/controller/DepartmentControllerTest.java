package com.example.demo.controller;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.example.demo.entities.Department;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DepartmentControllerTest {

	
	private static final String API_URI = "http://localhost:8889/api/departments";
	
	
	@Test
    public void whenGetAllDepartments_thenOK() {
        final Response response = RestAssured.given().get(API_URI);
        System.out.println("Status Code -->" + response.getStatusCode());
        System.out.println("Response Value -->" + response.asString());
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
    }
	
	
	@Test
    public void whenGetDepartmentById_thenOK() {
        final Response response = RestAssured.given().get(API_URI + "/1");
        System.out.println("Status Code -->" + response.getStatusCode());
        System.out.println("Response Value -->" + response.asString());
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
    }
	
	
	@Test
    public void givenNewDepartment_whenCreatedDepartment_thenOK() {
        final String departmentName = "MCA";
		final Department department = new Department();
        department.setName(departmentName);
        Response response = RestAssured.given().contentType(MediaType.APPLICATION_JSON_VALUE).body(department).post(API_URI);
        System.out.println("Status Code -->" + response.getStatusCode());
        System.out.println("Response Value -->" + response.asString());
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        
        ObjectMapper mapper = new ObjectMapper();
        long departmentId = 0;
        try {
			Department responseDepartment = mapper.readValue(response.asString(), Department.class);
			departmentId = responseDepartment.getNumber();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        response = RestAssured.given().get(API_URI + "/" + departmentId);
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        assertTrue(response.asString().contains(departmentName));

    }
	
	
	@Test
    public void givenExistingDepartment_whenUpdatedDepartment_thenOK() {
        final String departmentName = "MCAA";
		final Department department = new Department();
        department.setName(departmentName);
        department.setNumber(11L);
        Response response = RestAssured.given().contentType(MediaType.APPLICATION_JSON_VALUE).body(department).put(API_URI + "/" + department.getNumber());
        System.out.println("Status Code -->" + response.getStatusCode());
        System.out.println("Response Value -->" + response.asString());
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        
        ObjectMapper mapper = new ObjectMapper();
        long departmentId = 0;
        try {
			Department responseDepartment = mapper.readValue(response.asString(), Department.class);
			departmentId = responseDepartment.getNumber();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        response = RestAssured.given().get(API_URI + "/" + departmentId);
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        assertTrue(response.asString().contains(departmentName));

    }
	
}
