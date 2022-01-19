package decorator;

public class HelmetDecorator extends AbstractBikeDecorator {

	private AbstractBike bike;

	public HelmetDecorator(AbstractBike bike) {
		this.bike=bike;
	}


	
	public double getPrice() {
		return bike.getPrice() + 5;
	}
	
	public String getModel() {
		return   bike.getModel() +" with Helmet";
		
	}


}
	
	



