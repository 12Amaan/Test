package com.example.demo.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ElevatorDAO;
import com.example.demo.model.Direction;
import com.example.demo.model.Door;
import com.example.demo.model.Elevator;
import com.example.demo.model.ElevatorStatus;
import com.example.demo.model.ExternalElevatorDetails;
import com.example.demo.model.InvalidOperationException;


@Service
@org.springframework.transaction.annotation.Transactional
public class ServiceLayer implements ServiceIfc {
	
	 Logger logger = LoggerFactory.getLogger(ServiceLayer.class);

	@Autowired
	ElevatorDAO dao;
	
		@Override
			public Elevator moveToAnotherFloor(ExternalElevatorDetails details,Boolean needCapacityCheck) throws InvalidOperationException {
				
			logger.info("Inside moveToAnotherFloor with details"  +details);
			
				Optional<Elevator> e=null;
				Elevator elevator=null;
				
				System.out.println(details);
				try {
					
				 e=	dao.findById(details.getElevatorNumber());
				 
				}catch(Exception e1) {
					System.out.println(e);
				}
				
				
			if(e.isPresent()) {
				elevator = e.get();
				
				if(needCapacityCheck)
				validateCapacity(details.getNoOfPeopleInElevator(),elevator.getMaxCapacity());
				
				validateElevatorStatus(elevator);
				
				elevator=goToDestinationFloor(details.getCurrentFloor(), elevator);
			
				//dao.save(elevator);
			}else {
				//Exception Handling Part to be Developed for a User Message
				logger.error("No Elevator Found for the Requested Id"+ details.getElevatorNumber());
				throw new InvalidOperationException("Lift is out of Order or Currently not Available");
			}
				
				return elevator;
	}

	private void validateElevatorStatus(Elevator elevator) throws InvalidOperationException {
		
		if(elevator.getIsElevatorOutOfService() !=null && elevator.getIsElevatorOutOfService()) {
			
			logger.error("Requested Elevated Not Available"+ elevator);
			
			throw new InvalidOperationException("Out Of Service");
		}
			
	}

	@Override
	public Elevator goToDestinationFloor(Integer from, Elevator elevator) {
		
		
		//This Block Satifies Upward Movement thus we can say it is moving in up direction
		
		logger.info("Inside goToDestinationFloor with from and to Date"  + from + elevator.getCurrentFloor());
		
		if(from.compareTo(elevator.getCurrentFloor()) > 0) {
			
			for(int i=from;i<=elevator.getCurrentFloor();i++) {
				System.out.println("Floor No"+i);
			}
			
			elevator.setDirection(Direction.UP);
			elevator.setCurrentState(ElevatorStatus.RUNNING);
		}else if(from.compareTo(elevator.getCurrentFloor()) < 0) {
			
			for(int i=from;i<=elevator.getCurrentFloor();i++) {
				System.out.println("Floor No"+i);
			}
			
			elevator.setDirection(Direction.DOWN);
			elevator.setCurrentState(ElevatorStatus.RUNNING);
		}else {
			elevator.setCurrentFloor(from);
		}
			
		elevator.setCurrentState(ElevatorStatus.IDLE);
		elevator.setCurrentFloor(from);
		elevator.setStatusOfDoor(Door.OPEN);
		return elevator;
	}

	
	public void validateCapacity(Integer currentOccupency,Integer maxCapacity) throws InvalidOperationException {
		

		logger.info("Inside validateCapacity with currentOccupency and maxCapacity"  + currentOccupency + maxCapacity);
		
		if(currentOccupency.compareTo(maxCapacity)>=0) {
			
			logger.error("Max Occupency with CurrentValue"+ currentOccupency);
			
			throw new InvalidOperationException("Capacity is Reached");
			}
		}
	

	@Override
	public Elevator closeTheDoorRequest(String elevatorNumber) throws InvalidOperationException {
		
		Optional<Elevator> opElevator=null;
		Elevator elevator=null;
		
		if(elevatorNumber != null) {
			
				opElevator = dao.findById(Long.valueOf(elevatorNumber));
				if(opElevator.isPresent()) {
					
					elevator=opElevator.get();
					
					if(elevator.getCurrentState().equals(ElevatorStatus.RUNNING)) {
						throw new InvalidOperationException("Cannot Close the Door");
					}else
						elevator.setStatusOfDoor(Door.CLOSE);
					
					
				}else {
					throw new InvalidOperationException("Lift is out of Order or Currently not Available");
				}
				
			
		}else {
			throw new InvalidOperationException("No Elevator Selected");
		}
			
		
		return elevator;
	}

	@Override
	public Elevator addElevatorToSystem(Elevator elevator) {
		// TODO Auto-generated method stub
		
		if(elevator != null) {
			dao.save(elevator);
		}
		
		return elevator;
	}

	@Override
	public Elevator updateStatus(String elevatorNumber,Boolean status) throws InvalidOperationException {
		// TODO Auto-generated method stub
		
		Optional<Elevator> opElevator=null;
		Elevator elevator=null;
		
		if(elevatorNumber != null)
			elevator = updateStatus(elevatorNumber, elevator,status);
		else {
			throw new InvalidOperationException("No Elevator Selected");
		}
		return elevator;
	}

	private Elevator updateStatus(String elevatorNumber, Elevator elevator,Boolean isOutOfService) throws InvalidOperationException {
		Optional<Elevator> opElevator;
		
			opElevator = dao.findById(Long.valueOf(elevatorNumber));	
			if(opElevator.isPresent()) {
				elevator =opElevator.get();
				elevator.setIsElevatorOutOfService(isOutOfService);
			}else {
				throw new InvalidOperationException("No Elevator exist");
			}
			
		
		return elevator;
	}
	

}
