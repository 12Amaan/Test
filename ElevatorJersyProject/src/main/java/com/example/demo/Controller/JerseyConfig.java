package com.example.demo.Controller;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.example.demo.exceptionHandler.ExceptionHandler;

@Component
public class JerseyConfig  extends ResourceConfig{
	
	    public JerseyConfig() {
	        
	        register(ElevatorController.class);
	        register(ExceptionHandler.class);
	       // register(ReverseService.class);
	    }
	
}
