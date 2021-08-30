package com.example.demo.service;

import com.example.demo.model.Elevator;
import com.example.demo.model.ExternalElevatorDetails;
import com.example.demo.model.InvalidOperationException;

public interface ServiceIfc {
	
	//public Elevator moveToAnotherFloor(ExternalElevatorDetails details);
	
	public Elevator goToDestinationFloor(Integer from,Elevator elevator);
	
	public Elevator moveToAnotherFloor(ExternalElevatorDetails details,Boolean needCapacityCheck) throws InvalidOperationException;
	
	public Elevator closeTheDoorRequest(String elevatorNumber) throws InvalidOperationException;

	public Elevator addElevatorToSystem(Elevator elevator);

	public Elevator updateStatus(String elevatorNumber,Boolean OutofService) throws InvalidOperationException;

}
