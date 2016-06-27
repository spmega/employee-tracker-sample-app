package com.vpath.employeetracker.repository;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext
public class EmployeeTrackerRepositoryTest {

	@Autowired
	private EmployeeTrackerRepository repository;
	
	public EmployeeTrackerRepositoryTest() {
		// TODO Auto-generated constructor stub
	}
	
	@Before
	public void init(){
		if(repository == null);
	}
	
}
