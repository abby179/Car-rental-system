package com.abby.car;

public class GoodsCar extends Car {
	public int goodsCap;

	public GoodsCar(int goodsCap, String name, int rental) {
		super(name, rental);
		this.goodsCap = goodsCap;
	}
}
