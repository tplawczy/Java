package builder;

import java.util.ArrayList;
import java.util.List;

public class VehicleBuilder {

	private String model="A4";
	private String brand="Audi";
	private String bodywork="sedan";
	private Engine engine= new Engine("benzine",4);
	private int seatsNumber=5;
	private int doorsNumber=5;
	private List<String> accessories=new ArrayList<>();


	public VehicleBuilder setModel(String model) {
		this.model = model;
		return this;
	}


	public VehicleBuilder setBrand(String brand) {
		this.brand = brand;
		return this;
	}


	public VehicleBuilder setBodywork(String bodywork) {
		this.bodywork = bodywork;
		return this;
	}


	public VehicleBuilder setEngine(Engine engine) {
		this.engine = engine;
		return this;
	}


	public VehicleBuilder setSeatsNumber(int seatsNumber) {
		this.seatsNumber = seatsNumber;
		return this;
	}


	public VehicleBuilder setDoorsNumber(int doorsNumber) {
		this.doorsNumber = doorsNumber;
		return this;
	}


	public VehicleBuilder setAccessories(String accessories) {
		this.accessories.add(accessories);
		return this;
	}
	
	public Vehicle createVehicle() {
		return new Vehicle(model, brand, bodywork  ,engine, seatsNumber , doorsNumber, accessories);
	}


}