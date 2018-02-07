package com.abby.car;

public class PickupCar extends Car {
	public int passengerCap;
	public int goodsCap;

	public PickupCar(int passengerCap, int goodsCap, String name, int rental) {
		super(name, rental);
		this.passengerCap = passengerCap;
		this.goodsCap = goodsCap;
	}
}
