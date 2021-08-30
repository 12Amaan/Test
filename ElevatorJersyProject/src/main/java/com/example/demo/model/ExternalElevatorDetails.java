package com.example.demo.model;

import javax.persistence.*;


import org.springframework.stereotype.Component;




/*@Entity
@Table(name = "ExternalElevatorDetails")*/
@Component
public class ExternalElevatorDetails {
	
	
	
	public ExternalElevatorDetails() {
		super();
	}
	
	String whichDirectionTo;

	Integer currentFloor;
	
	Long elevatorNumber;

	Integer noOfPeopleInElevator;

	public Integer getNoOfPeopleInElevator() {
		return noOfPeopleInElevator;
	}

	public void setNoOfPeopleInElevator(Integer noOfPeopleInElevator) {
		this.noOfPeopleInElevator = noOfPeopleInElevator;
	}

	public Long getElevatorNumber() {
		return elevatorNumber;
	}

	public void setElevatorNumber(Long elevatorNumber) {
		this.elevatorNumber = elevatorNumber;
	}

	

	public ExternalElevatorDetails(String whichDirectionTo, Integer currentFloor, Long elevatorNumber,
			Integer noOfPeopleInElevator) {
		super();
		this.whichDirectionTo = whichDirectionTo;
		this.currentFloor = currentFloor;
		this.elevatorNumber = elevatorNumber;
		this.noOfPeopleInElevator = noOfPeopleInElevator;
	}

	public String getWhichDirectionTo() {
		return whichDirectionTo;
	}

	public void setWhichDirectionTo(String whichDirectionTo) {
		this.whichDirectionTo = whichDirectionTo;
	}

	public Integer getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(Integer currentFloor) {
		this.currentFloor = currentFloor;
	}

	@Override
	public String toString() {
		return "ExternalElevatorDetails [whichDirectionTo=" + whichDirectionTo + ", currentFloor=" + currentFloor
				+ ", elevatorNumber=" + elevatorNumber + ", noOfPeopleInElevator=" + noOfPeopleInElevator + "]";
	}



}
