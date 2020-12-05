package com.example.demo.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="EMPLOYEES")
public class Employee {

	@Id
	@Column(name="EMPLOYEE_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long employeeId;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="AGE")
	private int age;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PHONE_NUMBER")
	private String phoneNumber;
	
	@Column(name="HIRE_DATE")
	private LocalDate hireDate;
	
	@Column(name="SALARY")
	private Double salary;
	
	@ManyToOne
	@JoinColumn(name = "DEPARTMENT_ID_FK", referencedColumnName="DEPARTMENT_ID", nullable = false)
	@Fetch(FetchMode.JOIN)
	private Department departmentId;
	
	
	public Employee(Long id, String fName, String lName, String gen, int age, String email, String phoneNumber, LocalDate hDate, Double salary, Department department  ) {
		this.employeeId = id;
		this.firstName = fName;
		this.lastName = lName;
		this.gender = gen;
		this.age = age;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.hireDate = hDate;
		this.salary = salary;
		this.departmentId = department;
	}
	
	
	public Employee(String fName, String lName, String gen, int age, String email, String phoneNumber, LocalDate hDate, Double salary, Department department  ) {
		this.firstName = fName;
		this.lastName = lName;
		this.gender = gen;
		this.age = age;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.hireDate = hDate;
		this.salary = salary;
		this.departmentId = department;
	}
	
	public Employee() {
		
	}
	
	

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Department getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Department departmentId) {
		this.departmentId = departmentId;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", age=" + age + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", hireDate=" + hireDate + ", salary=" + salary
				+ ", departmentId=" + departmentId + "]";
	}
	
	
	
	
}
