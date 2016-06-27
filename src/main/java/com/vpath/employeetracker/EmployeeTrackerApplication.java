package com.vpath.employeetracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class EmployeeTrackerApplication{

	private static final Logger log = LoggerFactory.getLogger(EmployeeTrackerApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeTrackerApplication.class, args);
	}
	
	public static class Log{
		public static Logger returnLog(){
			return log;
		}
	}
	
}
