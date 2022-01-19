package shop;

public class Facade {
	
	public boolean isRentPossible(Customer customer, int bikeId) {
		EbikeShop ebikeShop = EbikeShop.getInstance();
		Bike bike = ebikeShop.getBikes().get(customer.getBikeIndex(bikeId));
		if (customer.getRentedBikes().size() > 0 ) {
			return false;
		} else if (bike.isRented()) {
			return false;
		} else if (bike.getBattery().getCharge() <= 30) {
			return false;
		} else if (customer.getCash() <= 30) {
			return false;
		}

		return true;
	}
	public String answer(boolean isRentPossible) {
		if(isRentPossible) {
			return "yes";
		}
		return "no";
	
	}
	
}