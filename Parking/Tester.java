/**
 * Manages a parking lot, allowing the user to add and retrieve cars from
 * the parking lot via a continuous menu.
 * 
 * @author Andrei Dumitrascu
 * @version JDK 17.0.7.3
 * @since 2022-07-12
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class Tester {

	public static void main(String[] args) {
		
		// Objects of type Car, created and assigned data using the constructor.
		Car Corolla = new Car("Corolla", 54334, 1);
		Car Camry = new Car("Camry", 54123, 1);
		Car Corvette = new Car("Corvette", 23424, 1);
		Car Escalade = new Car("Escalade", 45646, 1);
		
		Car GTO = new Car("GTO", 45677, 1);
		Car Pilot = new Car("Pilot", 34566, 1);
		Car F250 = new Car("F250", 65477, 1);
		
		Car Tundra = new Car("Tundra", 89678, 1);
		Car Corvair = new Car("Corvair", 96784, 1);
		Car Impala = new Car("Impala", 98274, 1);
		
		/* Stack 1, parking - the parking lot where cars want to park
		 * Stack 2, street - cars on the street
		 * 	Explanation: (when a car, other than the last one in,
		 *  needs to come out, all the cars sitting behind it have to back
		 *  out onto the street, and than come back in once the target car came
		 *  out of the parking) 
		 * 
		 * Queue, carLine -  cars waiting to enter the parking lot when its full
		 * Random, rand - used to generate a random decal, between 0 and 1.
		 * (Decal #1 - allowed to park, Decal #0 - not allowed to park)
		 * */
		Stack<Car> parking = new Stack<>();
		Stack<Car> street = new Stack<>();
		Queue<Car> carLine = new LinkedList<>();
		Random rand = new Random();
		
		// Previously created car objects inserted into the parking lot.
		parking.push(Corolla);
		parking.push(Camry);
		parking.push(Corvette);
		parking.push(Escalade);
		
		parking.push(GTO);
		parking.push(Pilot);
		parking.push(F250);
		
		parking.push(Tundra);
		parking.push(Corvair);
		parking.push(Impala);
		
		// Displays the cars in the parking lot and queue
		System.out.println("Parking lot status: ");
		for (int i = 0; i < parking.size(); i++) {
		    System.out.println(parking.get(i));
		}
		System.out.println("Number of cars parked: " + parking.size());
		
		System.out.println();
		System.out.println("Queue status: ");
		for (Car item: carLine) {
		    System.out.println(item);
		}
		System.out.println("Number of cars in the queue: " + carLine.size());
		
		Scanner scnr = new Scanner(System.in);
		
		int userMenuOption;
		do {
			System.out.println();
			System.out.println("Menu: ");
			System.out.println("1. Park a car");
			System.out.println("2. Retrieve a parked car");
			System.out.println("0. Exit");
			
			System.out.println();
			System.out.print("Please choose what you would like to do: ");
			System.out.println();
			userMenuOption = scnr.nextInt();
			
			switch (userMenuOption) {
			
			case 1:
				// If there are less than 15 cars in the parking, the user can park a car directly, without waiting in a queue.
				if (parking.size() < 15) {
					System.out.println("There is free space in the parking lot.");
					System.out.println("To add a car, fill out the form below: ");
					System.out.println();
					
					// User specifies the model and license number of a car, and a random decal is generated.
					System.out.println("Model: ");
					String carModel = scnr.next();
					
					System.out.println("License plate number (5 Digits): ");
					int carLicenseNum = scnr.nextInt();
					
					System.out.println("Decal Status: ");
					int carDecalStatus = rand.nextInt((1 - 0) + 1) + 0;
					System.out.println(carDecalStatus);
						
					// If the decal is 0, the person is not allowed to park.
					// if the decal is 1, the person is allowed to park.
						if (carDecalStatus == 0) {
							System.out.println("Sorry, you don't have the appropriate decal to park here.");
						}
						else {
							System.out.println("The car has been parked.");
							System.out.println();
							parking.push(new Car(carModel, carLicenseNum, carDecalStatus));
							
							System.out.println("Parking lot status: ");
							for (int i = 0; i < parking.size(); i++) {
							    System.out.println(parking.get(i));
							}
							System.out.println("Number of cars parked: " + parking.size());
							
							System.out.println();
							System.out.println("Queue status: ");
							for (Car item: carLine) {
							    System.out.println(item);
							}
							System.out.println("Number of cars in the queue: " + carLine.size());
						}
				}
				
				// Else if the parking lot is full, the user can add the car to a queue.
				else if (parking.size() >= 15) {
					System.out.println("The parking lot is full.");
					System.out.println("To add a car to the queue, fill out the form below: ");
					System.out.println();
					
					System.out.println("Model: ");
					String carModel = scnr.next();
					
					System.out.println("License plate number (5 Digits): ");
					int carLicenseNum = scnr.nextInt();
					
					System.out.println("Decal Status: ");
					int carDecalStatus = rand.nextInt((1 - 0) + 1) + 0;
					System.out.println(carDecalStatus);
						
						if (carDecalStatus == 0) {
							System.out.println("Sorry, you don't have the appropriate decal to park here.");
						}
						else {
							System.out.println("The car has been added to the queue.");
							System.out.println();
							carLine.add(new Car(carModel, carLicenseNum, carDecalStatus));
							
							System.out.println("Parking lot status: ");
							for (int i = 0; i < parking.size(); i++) {
							    System.out.println(parking.get(i));
							}
							System.out.println("Number of cars parked: " + parking.size());
							
							// Displays the cars waiting in the queue
							System.out.println();
							System.out.println("Queue status: ");
							for (Car item: carLine) {
							    System.out.println(item);
							}
							System.out.println("Number of cars in the queue: " + carLine.size());
						}
				}
				break;
				
			case 2:
				// User enters the license plate number of the car he wants to retrieve from the parking lot
				System.out.println();
				System.out.print("Please enter the license plate number: ");
				System.out.println();
				int userSelection = scnr.nextInt();
				
				// If the license plate number the user entered matches the last car in the parking lot, it is retrieved directly.   
				if (userSelection == parking.peek().getLicenseNum()) {
					parking.pop();
					System.out.println();
					System.out.println("The car with license #: " + userSelection + " has been retrieved from the parking lot.");
					System.out.println();
					
					// If the parking lot now has free space, the cars waiting in the queue are automatically parked in the lot.
					if (parking.size() < 15 && carLine.size() > 0) {
						System.out.println("The parking lot now has free space.");
						System.out.println("Parking the cars sitting in the queue...");
						System.out.println();
						
					// Checks that the decal is 1, and moves the car from the queue to the parking lot.
					while (parking.size() < 15 && carLine.size() > 0) {
						if (carLine.peek().getDecal() == 1) {
							parking.push(carLine.remove());
						}
					}
					}
					
					// Displays the cars in the parking
					System.out.println("Parking lot status: ");
					for (int i = 0; i < parking.size(); i++) {
					    System.out.println(parking.get(i));
					}
					System.out.println("Number of cars parked: " + parking.size());
					
					// Displays the cars in the queue
					System.out.println();
					System.out.println("Queue status: ");
					for (Car item: carLine) {
					    System.out.println(item);
					}
					System.out.println("Number of cars in the queue: " + carLine.size());
				}
				
				/*Else if the license plate number the user entered matches any car other than the last one in the parking lot,
				each car is moved from the parking lot stack, to the street stack until the target car that the user wants to 
				retrieve is reached.*/
				else if (userSelection != parking.peek().getLicenseNum()) {
					// Cars in the parking lot are moved to the street
					while (parking.peek().getLicenseNum() != userSelection) {
						street.push(parking.pop());
					}					
					// The updated parking and street stacks are displayed.
					System.out.println("Parking lot after cars are moved to the street: ");
					for (int i = 0; i < parking.size(); i++) {
					    System.out.println(parking.get(i));
					}
					System.out.println("Cars in the parking lot: " + parking.size());
					
					System.out.println();
					System.out.println("Cars moved to the street: ");
					for (int i = 0; i < street.size(); i++) {
					    System.out.println(street.get(i));
					}
					System.out.println("Cars in the street: " + street.size());
					
					// The target car is retrieved.
					parking.pop();
					System.out.println();
					System.out.println("The car with license #: " + userSelection + " has been retrieved from the parking lot.");
					System.out.println("Cars on the street moving back to the parking lot...");
					System.out.println();
					
					// Cars in the street are moved to the parking lot
					while (street.size() > 0) {
						parking.push(street.pop());
					}
					
					System.out.println("Parking lot status: ");
					for (int i = 0; i < parking.size(); i++) {
					    System.out.println(parking.get(i));
					}
					
					System.out.println();
					System.out.println("Queue status: ");
					for (Car item: carLine) {
					    System.out.println(item);
					}
					System.out.println("Number of cars in the queue: " + carLine.size());
					
					// If the parking lot now has free space, the cars waiting in the queue are automatically parked in the lot.
					if (parking.size() < 15 && carLine.size() > 0) {
						System.out.println();
						System.out.println("The parking lot now has free space.");
						System.out.println("Parking the cars sitting in the queue...");
						System.out.println();
						
					while (parking.size() < 15 && carLine.size() > 0) {
						if (carLine.peek().getDecal() == 1) {
							parking.push(carLine.remove());
						}
					}
					
					System.out.println("Parking lot status: ");
					for (int i = 0; i < parking.size(); i++) {
					    System.out.println(parking.get(i));
					}
					System.out.println("Number of cars parked: " + parking.size());
					
					System.out.println();
					System.out.println("Queue status: ");
					for (Car item: carLine) {
					    System.out.println(item);
					}
					System.out.println("Number of cars in the queue: " + carLine.size());
					}
				}
				break;
			
			case 0:
				System.out.println("Exiting program, good bye!");
				break;
				
			
			}
		} while (userMenuOption != 0);
		
		scnr.close();
	}
}
