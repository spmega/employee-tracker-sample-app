package com.vpath.employeetracker.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vpath.employeetracker.dto.EmployeeDTO;
import com.vpath.employeetracker.service.EmployeeTrackerService;

@RestController
@RequestMapping("/api")
public class EmployeeTrackerRestController {

	@Autowired
	private EmployeeTrackerService service;
	
	public EmployeeTrackerRestController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("/employee/{id}")
	public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable int id){
		if(id == 0){
			id = 1;
		}
		
		EmployeeDTO employee = service.getEmployeeById(new Integer(id).longValue());
		
		HttpHeaders httpHeaders = new HttpHeaders();
		
		ResponseEntity<EmployeeDTO> response = 
				new ResponseEntity<EmployeeDTO>(employee, httpHeaders, HttpStatus.ACCEPTED);
		
		return response;
	}

	@RequestMapping("/all")
	public ResponseEntity<List<EmployeeDTO>> getAllEmployees(){
		
		List<EmployeeDTO> employeeDtoList = service.getAll();
		
		HttpHeaders httpHeaders = new HttpHeaders();
		
		ResponseEntity<List<EmployeeDTO>> response = 
				new ResponseEntity<List<EmployeeDTO>>(employeeDtoList, httpHeaders, HttpStatus.ACCEPTED);
		
		return response;
	}

	
	@RequestMapping(value = "/create", method = RequestMethod.PUT)
	public ResponseEntity<List<EmployeeDTO>> createEmployee(@RequestBody EmployeeDTO employeeDtoToBeSaved){
		service.addEmployee(employeeDtoToBeSaved);
		
		List<EmployeeDTO> savedEmployeeDto = service.getEmployeesByFirstNameAndLastName(employeeDtoToBeSaved.getFirstName(),
				employeeDtoToBeSaved.getLastName());
		
		HttpHeaders httpHeaders = new HttpHeaders();
		
		ResponseEntity<List<EmployeeDTO>> response = 
				new ResponseEntity<List<EmployeeDTO>>(savedEmployeeDto, httpHeaders, HttpStatus.ACCEPTED);
		
		return response;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PATCH)
	public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody EmployeeDTO updatedEmployee){
		
		service.update(updatedEmployee);
		
		EmployeeDTO savedEmployeeDto = service.getEmployeeById(updatedEmployee.getId());
		
		HttpHeaders httpHeaders = new HttpHeaders();
		
		ResponseEntity<EmployeeDTO> response = 
				new ResponseEntity<EmployeeDTO>(savedEmployeeDto, httpHeaders, HttpStatus.ACCEPTED);
		
		return response;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public ResponseEntity<EmployeeDTO> deleteEmployee(@RequestBody EmployeeDTO employeeDto){
		
		service.deleteEmployee(employeeDto);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		
		ResponseEntity<EmployeeDTO> response = 
				new ResponseEntity<EmployeeDTO>(employeeDto, httpHeaders, HttpStatus.ACCEPTED);
		
		return response;
	}

}
