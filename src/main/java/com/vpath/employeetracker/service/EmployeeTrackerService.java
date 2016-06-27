package com.vpath.employeetracker.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.vpath.employeetracker.dao.Employee;
import com.vpath.employeetracker.dto.EmployeeDTO;
import com.vpath.employeetracker.repository.EmployeeTrackerRepository;

@Service
@Component
public class EmployeeTrackerService {

	@Autowired
	private EmployeeTrackerRepository repository;
	
	public EmployeeTrackerService() {
		// TODO Auto-generated constructor stub
	}
	
	public EmployeeDTO getEmployeeById(long id){
		return convertEmployeeToDto(repository.findOne(id))[0];
	}
	
	public List<EmployeeDTO> getEmployeesByFirstName(String firstName){
		List<Employee> employeeList = repository.findByFirstName(firstName);
		Employee[] employeeArray = (Employee[]) employeeList.toArray();
		EmployeeDTO[] employeeDtos = convertEmployeeToDto(employeeArray);
		List<EmployeeDTO> employeeDtoList = new ArrayList<EmployeeDTO>();
		for(int i = 0; i < employeeDtos.length; i++){
			employeeDtoList.add(employeeDtos[i]);
		}
		return employeeDtoList;
	}
	
	public List<EmployeeDTO> getEmployeesByLastName(String lastName){
		List<Employee> employeeList = repository.findByLastName(lastName);
		Employee[] employeeArray = (Employee[]) employeeList.toArray();
		EmployeeDTO[] employeeDtos = convertEmployeeToDto(employeeArray);
		List<EmployeeDTO> employeeDtoList = new ArrayList<EmployeeDTO>();
		for(int i = 0; i < employeeDtos.length; i++){
			employeeDtoList.add(employeeDtos[i]);
		}
		return employeeDtoList;
	}
	
	public List<EmployeeDTO> getEmployeesByFirstNameAndLastName(String firstName, String lastName){
		List<Employee> employeeList = repository.findByFirstNameAndLastName(firstName, lastName);
		Employee[] employeeArray = new Employee[employeeList.size()];
		employeeArray = employeeList.toArray(employeeArray);
		EmployeeDTO[] employeeDtos = convertEmployeeToDto(employeeArray);
		List<EmployeeDTO> employeeDtoList = new ArrayList<EmployeeDTO>();
		for(int i = 0; i < employeeDtos.length; i++){
			employeeDtoList.add(employeeDtos[i]);
		}
		return employeeDtoList;
	}
	
	public List<EmployeeDTO> getEmployeesByAge(int age){
		List<Employee> employeeList = repository.findByAge(age);
		Employee[] employeeArray = (Employee[]) employeeList.toArray();
		EmployeeDTO[] employeeDtos = convertEmployeeToDto(employeeArray);
		List<EmployeeDTO> employeeDtoList = new ArrayList<EmployeeDTO>();
		for(int i = 0; i < employeeDtos.length; i++){
			employeeDtoList.add(employeeDtos[i]);
		}
		return employeeDtoList;
	}
	
	public void update(EmployeeDTO updatedEmployeedto){
		
		EmployeeDTO employeeToBeUpdated = convertEmployeeToDto(repository.findOne(updatedEmployeedto.getId()))[0];
		
		employeeToBeUpdated.setAge(updatedEmployeedto.getAge());
		employeeToBeUpdated.setFirstName(updatedEmployeedto.getFirstName());
		employeeToBeUpdated.setLastName(updatedEmployeedto.getLastName());
		
		repository.save(convertDTOToEmployee(employeeToBeUpdated)[0]);
		
		updatedEmployeedto = null;
		employeeToBeUpdated = null;
	}
	
	public void addEmployee(EmployeeDTO employeedto){	
		Employee employee = new Employee();
		employee.setAge(employeedto.getAge());
		employee.setFirstName(employeedto.getFirstName());
		employee.setLastName(employeedto.getLastName());
		
		repository.save(employee);
		
		employeedto = null;
		employee = null;
	}
	
	public void deleteEmployee(EmployeeDTO employeedto){
		Employee[] employee = convertDTOToEmployee(employeedto);
		
		repository.delete(employee[0]);
		
		employeedto = null;
		employee = null;
	}
	
	private EmployeeDTO[] convertEmployeeToDto(Employee... employees){
		EmployeeDTO[] employeeDtos = new EmployeeDTO[employees.length];
		EmployeeDTO employeedto = null;
		
		int counter = 0;
		for(Employee employee: employees){
			employeedto = new EmployeeDTO();
			employeedto.setId(employee.getId());
			employeedto.setAge(employee.getAge());
			employeedto.setFirstName(employee.getFirstName());
			employeedto.setLastName(employee.getLastName());
			
			employeeDtos[counter] = employeedto;
			
			counter++;
		}
		
		return employeeDtos;
	}
	
	private Employee[] convertDTOToEmployee(EmployeeDTO... employeedtos){
		Employee[] employees = new Employee[employeedtos.length];
		Employee employee = null;
		
		int counter = 0;
		for(EmployeeDTO employeedto: employeedtos){
			employee = new Employee();
			employee.setId(employeedto.getId());
			employee.setAge(employeedto.getAge());
			employee.setFirstName(employeedto.getFirstName());
			employee.setLastName(employeedto.getLastName());
			
			employees[counter] = employee;
			
			counter++;			
		}
		
		return employees;
	}

	public List<EmployeeDTO> getAll() {
		// TODO Auto-generated method stub
		Iterable<Employee> iteratable =  repository.findAll();
		Iterator<Employee> iterator = iteratable.iterator();
		
		List<EmployeeDTO> arrayList = new ArrayList<EmployeeDTO>();
		
		while(iterator.hasNext()){
			arrayList.add(convertEmployeeToDto(iterator.next())[0]);
		}
		
		iteratable = null;
		iterator = null;
		
		return arrayList;
	}

}
