package iterator;
import java.util.List;

import shop.Bike;

public interface IBikeShop {

		public List<Bike> getBikes();
		
		public Iterator createIterator(String IteratorType);
	

}
