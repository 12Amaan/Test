package com.example.demo.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;





@Entity
@Table(name = "Elevator")
public class Elevator {
	
	@Id
	Long id;
	
	@Column(name = "CurrentFloor")
	Integer currentFloor;
	
	/**
	 * Up and Down Option
	 */
	@Column(name = "Direction")
	@Enumerated(EnumType.ORDINAL)
	Direction direction;
	
	/**
	 * 0-->Idle State
	 * 1-->Running State
	 */
	@Column(name = "CurrentState") 
	@Enumerated(EnumType.ORDINAL)
	ElevatorStatus currentState;
	
	@Column(name = "Door") 
	@Enumerated(EnumType.ORDINAL)
	Door statusOfDoor;
	
	@Column(name="MaxCapacity")
	Integer maxCapacity;
	
	@Column(name="OutOfService")
	Boolean isElevatorOutOfService;

	public Boolean getIsElevatorOutOfService() {
		return isElevatorOutOfService;
	}





	public void setIsElevatorOutOfService(Boolean isElevatorOutOfService) {
		this.isElevatorOutOfService = isElevatorOutOfService;
	}





	public Elevator() {
		super();
	}


	
	
	
	@Override
	public String toString() {
		return "Elevator [id=" + id + ", currentFloor=" + currentFloor + ", direction=" + direction + ", currentState="
				+ currentState + ", statusOfDoor=" + statusOfDoor + ", maxCapacity=" + maxCapacity + "]";
	}





	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCurrentFloor() {
		return currentFloor;
	}





	public Direction getDirection() {
		return direction;
	}





	public void setDirection(Direction direction) {
		this.direction = direction;
	}





	public ElevatorStatus getCurrentState() {
		return currentState;
	}





	public void setCurrentState(ElevatorStatus currentState) {
		this.currentState = currentState;
	}





	public Door getStatusOfDoor() {
		return statusOfDoor;
	}





	public void setStatusOfDoor(Door statusOfDoor) {
		this.statusOfDoor = statusOfDoor;
	}





	public void setCurrentFloor(Integer currentFloor) {
		this.currentFloor = currentFloor;
	}










	public Elevator(Long id, Integer currentFloor, Direction direction, ElevatorStatus currentState, Door statusOfDoor,
			Integer maxCapacity, Boolean isElevatorOutOfService) {
		super();
		this.id = id;
		this.currentFloor = currentFloor;
		this.direction = direction;
		this.currentState = currentState;
		this.statusOfDoor = statusOfDoor;
		this.maxCapacity = maxCapacity;
		this.isElevatorOutOfService = isElevatorOutOfService;
	}





	public Integer getMaxCapacity() {
		return maxCapacity;
	}





	public void setMaxCapacity(Integer maxCapacity) {
		this.maxCapacity = maxCapacity;
	}


	


}
