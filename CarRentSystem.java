package com.abby.car;
import java.util.Scanner;

public class CarRentSystem {

	private static Scanner in;	

	public static void main(String[] args) {
		
		//define car array, store car objects to this array
		Car[] cars = {new PassengerCar(4,"Audi A4",500), new PassengerCar(4,"Mazda",400), new PickupCar(4,2,"Pickup-Snow",450), new PassengerCar(20,"Gold-Gragon",800), new GoodsCar(4,"SongHuaJiang",400), new GoodsCar(20,"Iveco",1000)};
				
		System.out.println("Welcome to the car rent system!");
		System.out.println("Do you want to rent cars? 1.Yes 2.No");
		
		//choose if you want to rent cars
		in = new Scanner(System.in);
		int op = in.nextInt();
		
		switch(op){
		//rent car case
		case 1:
			//list out all available cars
			System.out.println("Cars for rent and the information of these cars:");
			System.out.printf("%-8s%-15s%-15s%-25s%n","Num","Name","Rental","Capacity");
			int count = 1;
			for(Car currentCar:cars){
				if(currentCar instanceof PassengerCar){
					System.out.printf("%-8s%-15s%-15s%-25s%n",count,currentCar.name,currentCar.rental+"/day","people: "+((PassengerCar)currentCar).passengerCap);
				}
				else if (currentCar instanceof GoodsCar){
					System.out.printf("%-8s%-15s%-15s%-25s%n",count,currentCar.name,currentCar.rental+"/day","goods: "+((GoodsCar)currentCar).goodsCap+"ton");
				}
				else if (currentCar instanceof PickupCar){
					System.out.printf("%-8s%-15s%-15s%-25s%n",count,currentCar.name,currentCar.rental+"/day","people: "+((PickupCar)currentCar).passengerCap+", goods: "+((PickupCar)currentCar).goodsCap+"ton");
				}
				count++;
			}
			
			System.out.println("How many cars would you like to rent?");
			op = in.nextInt();
			//setup array to store selected car number
			int[] carNum = new int[op];
			for(int i = 1; i < op+1; i++ ) {
				System.out.println("Please input the " + i + " car's number:");
				int cn = in.nextInt();
				carNum[i-1] = cn;
			}
			
			System.out.println("How many days would you like to rent the cars?");
			int days = op = in.nextInt();
			
			//count total capacity and price
			int countPassenger = 0;
			int countGoods = 0;
			int ttlPrice = 0;
			String pCars = "";
			String gCars = "";
			for(int j:carNum) {
				if(cars[j-1] instanceof PassengerCar){
					countPassenger += ((PassengerCar)cars[j-1]).passengerCap;
					pCars += (cars[j-1].name + " ");
				}else if(cars[j-1] instanceof GoodsCar){
					countGoods += ((GoodsCar)cars[j-1]).goodsCap;
					gCars += (cars[j-1].name + " ");
				}else if(cars[j-1] instanceof PickupCar){
					countGoods += ((PickupCar)cars[j-1]).goodsCap;
					countPassenger += ((PickupCar)cars[j-1]).passengerCap;
					pCars += (cars[j-1].name + " ");
					gCars += (cars[j-1].name + " ");
				}
				ttlPrice += cars[j-1].rental;
			}			
			ttlPrice = ttlPrice * days;
			
			//list out the bill
			System.out.println("Your bills as below:");
			System.out.println("***Cars that could carry passengers are:");
			System.out.println(pCars + " *Total passenger capacity:" + countPassenger + " people");
			System.out.println("***Cars that could carry goods are:");
			System.out.println(gCars + " *Total goods capacity:" + countGoods + " ton");
			System.out.println("***Total price:" + ttlPrice);
			
			break;
			
		case 2:
			System.out.println("Not rent!");
			break;
		}
	}
}
