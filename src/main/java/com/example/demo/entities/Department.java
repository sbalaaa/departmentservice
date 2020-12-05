package com.example.demo.entities;

import javax.persistence.*;

@Entity
@Table(name="departments")
public class Department  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DEPARTMENT_ID")
	private Long number;

	@Column(name="DEPARTMENT_NAME")
	private String name;

	public Department() {
	}
	
	public Department(String departmentName) {
		this.name = departmentName;
	}
	
	public Department(Long number) {
		this.number = number;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

}