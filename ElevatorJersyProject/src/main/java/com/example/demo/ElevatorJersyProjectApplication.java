package com.example.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.example.demo.dao.ElevatorDAO;
import com.example.demo.model.Door;
import com.example.demo.model.Elevator;
import com.example.demo.model.ElevatorStatus;

@SpringBootApplication
public class ElevatorJersyProjectApplication {

	@Autowired
	ElevatorDAO dao;

	
	  @PostConstruct public void initDB() { Elevator e1=new Elevator(1L, 0,null ,
	  ElevatorStatus.IDLE, Door.CLOSE,15,false); dao.save(e1);
	  
	  }
	 
	/*
	 * @Override protected SpringApplicationBuilder
	 * configure(SpringApplicationBuilder builder) { return
	 * builder.sources(ElevatorJersyProjectApplication.class); }
	 */

	public static void main(String[] args) {
		SpringApplication.run(ElevatorJersyProjectApplication.class, args);
	}

	/*
	 * public static void main(String[] args) { new
	 * ElevatorJersyProjectApplication() .configure(new
	 * SpringApplicationBuilder(ElevatorJersyProjectApplication.class)).run(args); }
	 */

}
