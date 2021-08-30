package com.example.demo.Controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.Elevator;
import com.example.demo.model.ExternalElevatorDetails;
import com.example.demo.model.InvalidOperationException;
import com.example.demo.service.ServiceIfc;


@Path("/ElevatorOperation")
public class ElevatorController {

	@Autowired
	ServiceIfc service;

	    @POST
	    @Path("/getElevator")
	    @Produces("application/json")
	    @Consumes("application/json")
	    public Elevator getElevator(@RequestBody ExternalElevatorDetails details) throws InvalidOperationException {
	    	System.out.println("Called");
	        return service.moveToAnotherFloor(details,false);
	    }
	    
	     
	    @PUT
	    @Path("/buttonPressed")
	    @Produces("application/json")
	    @Consumes("application/json")
	    public Elevator moveElevatorToSelectedFloor(@RequestBody ExternalElevatorDetails details) throws InvalidOperationException {
			 return service.moveToAnotherFloor(details,true);
	    	
	    }
	    
	    @PUT
	    @Path("/floorReached/{elevatorNumber}")
	    @Produces("application/json")
	    @Consumes("application/json")
	    public Elevator closeDoorRequest(@PathParam("elevatorNumber") String elevatorNumber) throws InvalidOperationException {
			 return service.closeTheDoorRequest(elevatorNumber);
	    	
	    }
	    

	    @POST
	    @Path("/addElevator")
	    @Produces("application/json")
	    public Elevator addElevatorToSystem(@RequestBody Elevator elevator) throws InvalidOperationException {
	    	System.out.println("Called");
	        return service.addElevatorToSystem(elevator);
	    }
	
	    @DELETE
	    @Path("/updateStatusOutOfSercice/{elevatorNumber}")
	    @Produces("application/json")
	    public Elevator updateStatusToOutofService(@PathParam("elevatorNumber") String elevatorNumber) throws InvalidOperationException {
			 return service.updateStatus(elevatorNumber,true);
	    	
	    }
	    
	    @PUT
	    @Path("/updateStatusActive/{elevatorNumber}")
	    @Produces("application/json")
	    public Elevator updateStatusToActive(@PathParam("elevatorNumber") String elevatorNumber) throws InvalidOperationException {
			 return service.updateStatus(elevatorNumber,false);
	    	
	    }
}
