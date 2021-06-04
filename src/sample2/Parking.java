package sample2;

import java.util.Scanner;

public class Parking {
	private String carType;
	private double hours;
	
	public Parking(String type) {
		hours = 1;
		carType = type;
	}

	public String getCarType() {
		return carType;
	}



	public void setCarType(String carType) {
		this.carType = carType;
	}



	public double getHours() {
		return hours;
	}



	public void setHours(double hours) {
		this.hours = hours;
	}

	public double calculatePrice(double spentHours) {
		int price = 0;
		hours = spentHours;
		switch(this.carType) {
		case "vehicle":
		case "Vehicle":
			price = 2;
			break;
		case "bus":
		case "Bus":
			price = 3;
			break;
		case "truck":
		case "Truck":
			price = 4;
			break;
		}
		return price * hours;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parking parking;
		System.out.println("Enter your car type: ");
		Scanner scan = new Scanner(System.in);
		String carType = scan.next();
		System.out.println("Enter the time spent (hours): ");
		double hours = scan.nextDouble();
		parking = new Parking(carType);
		System.out.print("Your due fees is: " + parking.calculatePrice(hours) + " KD");
	}

}
