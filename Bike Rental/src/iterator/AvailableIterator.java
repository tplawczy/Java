package iterator;

import java.util.List;

import shop.Bike;


public class AvailableIterator implements Iterator {

	private int position;	
	List<Bike> bikes;
	private Integer id;

	public AvailableIterator(List<Bike> bikes) {
		this.bikes = bikes;
	}

	@Override
	public Bike nextBike() {
		Bike bike = null;
		for (; position < bikes.size(); position++ ) {
			if (!(bikes.get(position)).isRented()) {
				bike = bikes.get(position);
			position++;
			break;
			}
		}

		return bike;
	}
	@Override
	public Bike nextBike(int id) {
		return null;
		
		}

	
	@Override

	public boolean isLastBike() {
		for (int i = position; i < bikes.size(); i++) {
			if (!(bikes.get(i)).isRented()) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Bike currentBike() {
		if (position <= bikes.size()) {
			return bikes.get(position-1);
		}
		return null;
	}

}
