package iterator;

import java.util.List;

import shop.Bike;

public class BikeIdIterator implements Iterator{
	private int position;
	List<Bike> bikes;
	int id;
	
	

	public BikeIdIterator(List<Bike> bikes) {
		this.bikes = bikes;
	
	}

	@Override
	public Bike nextBike(int id) {
		Bike bike = null;
		for (; position <bikes.size(); position++){
			if (id==(bikes.get(position).getBikeId())) { 
				bike = bikes.get(position);
			position++;
			break;
			}
		}
		return bike;
	}
	@Override
	public Bike nextBike() {
		return null;
		
		}

		
	@Override

	public boolean isLastBike() {
		return false;
	}

	@Override
	public Bike currentBike() {
		if (position <= bikes.size()) {
			return bikes.get(position-1);
		}
		return null;
	}

}
