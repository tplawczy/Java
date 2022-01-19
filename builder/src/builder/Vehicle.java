package builder;

import java.util.List;

/**
 * TODO: Document this class / interface here
 *
 * @since v8.0
 */
public class Vehicle {
	

    private String model;
	private String brand; 
    private String bodywork;
    private Engine engine;
    private int  seatsNumber;
    private int doorsNumber;
    private List<String> accessories;
    

    public Vehicle(final String model, final String brand,  final  String bodywork  , final Engine engine, final int seatsNumber , final int doorsNumber, final List<String> accessories) {
        
    	this.model=model;
    	this.brand=brand;
        this.bodywork = bodywork;
        this.engine = engine;
        this.seatsNumber=seatsNumber;
     this.doorsNumber=doorsNumber;
     this.accessories = accessories;
     
}
 
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getBodywork() {
		return bodywork;
	}
	public void setBodywork(String bodywork) {
		this.bodywork = bodywork;
	}
	public Engine getEngine() {
			return engine;
	}
	public int getSeatsNumber() {
		return seatsNumber;
	}
	public void setSeatsNumber(int seatsNumber) {
		this.seatsNumber = seatsNumber;
	}
	public int getDoorsNumber() {
		return doorsNumber;
	}
	public void setDoorsNumber(int doorsNumber) {
		this.doorsNumber = doorsNumber;
	}
	public List<String> getAccessories() {
		return accessories;
	}
	public void setAccessories(List<String> accessories) {
		this.accessories = accessories;
	}


   

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Vehicle{");
        sb.append("Model =").append(model+"\n");
        sb.append("Brand =").append(brand+"\n");
        sb.append("Bodywork =").append(bodywork+"\n");
        sb.append("Engine= ").append(engine+"\n");
        sb.append("Number of seats =").append(seatsNumber+"\n");
        sb.append("Number of doors =").append(doorsNumber+"\n");
        sb.append("Accessories =").append(accessories);
    
        sb.append('}');
        return sb.toString();
    }
}
