package shop;

import java.util.ArrayList;
import java.util.List;

import decorator.AbstractBike;
import enums.BikeType;
import enums.ForWhom;


public class Bike extends AbstractBike implements Cloneable {

	private  ForWhom forWhom;
	private  double price;
	private  Battery battery;
	private  boolean rented ;
	private  int kilometers;
	
	
	   

	public Bike(int bikeId, BikeType type, String model, ForWhom forWhom, Double price, Battery battery,
			boolean rented, int kilometers) {
		
		this.bikeId = bikeId;
		this.type = type;
		this.model = model;
		this.forWhom = forWhom;
		this.price = price;
		this.battery=battery;
		this.rented = rented;
		this.kilometers = kilometers;
	}
@Override
	public double getPrice() {
		return price;
	}
@Override
	public String getModel() {
		return model;
	}

	public Battery getBattery() {
		return battery;
	}

	public boolean isRented() {
		return rented;
	}

	public int getKilometers() {
		return kilometers;
	}

	public int getBikeId() {
		return bikeId;
	}

	public void setBattery(Battery battery) {
		this.battery=battery;
	}

	public void setBikeId(int bikeId) {
		this.bikeId = bikeId;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}

	public Bike clone() throws CloneNotSupportedException {
		Bike bike = (Bike) super.clone();
        bike.setBattery((Battery) getBattery().clone());
		return bike;
	}

	@Override
	public String toString() {
		return

		"Bike {" + "id=" + bikeId + 
		", Model=" + model + 
		", Bike Type=" + type + 
		", Battery=" + battery.getCharge() +"%" + 
		", Is rented=" + rented + 
		", Price=" + price + 
		", For whom =" + forWhom + 
		", Kilometers=" + kilometers + 
		"}\n";
	

		}
	}
