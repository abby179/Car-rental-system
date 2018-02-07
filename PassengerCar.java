package com.abby.car;

public class PassengerCar extends Car {
	public int passengerCap;

	public PassengerCar(int passengerCap, String name, int rental) {
		super(name, rental);
		this.passengerCap = passengerCap;
	}
}
