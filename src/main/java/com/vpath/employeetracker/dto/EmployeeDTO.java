package com.vpath.employeetracker.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeDTO {

	@JsonProperty("id")
	private long id;
	
	@Min(18)
	private int age;
	
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	
	public EmployeeDTO() {
		// TODO Auto-generated constructor stub
	}

	@JsonCreator
	public EmployeeDTO(@JsonProperty("age") int age,
			@JsonProperty("firstName") String firstName,
			@JsonProperty("lastName") String lastName) {
		super();
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	@Override
	public String toString() {
		return "EmployeeDTO [id=" + id + ", age=" + age + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
