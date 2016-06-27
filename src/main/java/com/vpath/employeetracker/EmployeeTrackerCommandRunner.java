package com.vpath.employeetracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.vpath.employeetracker.dao.Employee;
import com.vpath.employeetracker.repository.EmployeeTrackerRepository;
import com.vpath.employeetracker.service.EmployeeTrackerService;

@Component
public class EmployeeTrackerCommandRunner implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(EmployeeTrackerApplication.class);
	
	@Autowired
	private EmployeeTrackerRepository repository;
	
	@Autowired
	private EmployeeTrackerService service;
	
	public EmployeeTrackerCommandRunner() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		log.info("Saving an employee named Nag Pachava");
		
		Employee savedEmployee = repository.findOne(1L);
		if(savedEmployee.getAge() != 40 
				|| !savedEmployee.getFirstName().equalsIgnoreCase("Nag") 
				|| !savedEmployee.getLastName().equalsIgnoreCase("Pachava")){
			log.debug("The employee called Nag Pachava was not able to be saved by data.sql!"
					+ "Instead the value is " + savedEmployee.toString());
		}
		
		/*Employee savedEmployeeFromService = service.getEmployeeById(1L);
		if(!savedEmployee.equals(savedEmployeeFromService)){
			log.debug("The employee called Nag Pachava was not able to be be retrieved by the service!");
		} else{
			log.debug("The employee called Nag Pachava was able to be be retrieved by the service!");
		}*/
	}

}
