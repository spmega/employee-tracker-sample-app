package com.vpath.employeetracker.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vpath.employeetracker.dao.Employee;

@Repository
public interface EmployeeTrackerRepository extends CrudRepository<Employee, Long>{
	
	List<Employee> findByFirstName(String name);
	List<Employee> findByLastName(String name);
	List<Employee> findByAge(int age);
	List<Employee> findByFirstNameAndLastName(String firstName, String lastName);
	
}
