package decorator;

import enums.BikeType;

public abstract class AbstractBike {

	
	public  int bikeId;
	public  BikeType type;
	public  String model;

	public abstract String getModel();
	
	public abstract double getPrice();

	
}
