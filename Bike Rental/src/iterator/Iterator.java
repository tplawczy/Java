package iterator;

import shop.Bike;

public interface Iterator {
	

		public Bike nextBike();
		
		public Bike nextBike(int id);

		public boolean isLastBike();		

		public Bike currentBike();
	}

