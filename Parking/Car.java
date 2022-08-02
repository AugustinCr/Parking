/**
 * Provides the Tester class with a constructor, toString, and getters and setters. 
 * 
 * @author Andrei Dumitrascu
 * @version JDK 17.0.7.3
 * @since 2022-07-12
 */

public class Car {
	private String carModel;
	private Integer licenseNum;
	private int decal;
	
	// Constructor used to create objects
	public Car(String carModel, Integer licenseNum, int i) {
		super();
		this.carModel = carModel;
		this.decal = i;
		this.licenseNum = licenseNum;
	}
	
	// Setter and getter methods for the car attributes
	public String getCarModel() {
		return carModel;
	}


	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}


	public Integer getLicenseNum() {
		return licenseNum;
	}


	public void setLicenseNum(Integer licenseNum) {
		this.licenseNum = licenseNum;
	}


	public int getDecal() {
		return decal;
	}


	public void setDecal(int decal) {
		this.decal = decal;
	}

	// Allows the program to display the car model, license number, and decal, instead of the memory location. 
	@Override
	public String toString() {
		return ("Model: " + carModel + " | License Number: " + licenseNum + " | Decal Satus: " + decal);
	}
}
