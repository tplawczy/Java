package decorator;

public class TrailerDecorator extends AbstractBikeDecorator {

	private AbstractBike bike;

	public TrailerDecorator(AbstractBike bike) {
		this.bike = bike;
	}

	
	public double getPrice() {
		return bike.getPrice() + 10;
	}


	public String getModel() {
		return bike.getModel() + " with Trailer";
	}
}
