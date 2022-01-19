package shop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import enums.BikeType;
import enums.ForWhom;
import iterator.AvailableIterator;
import iterator.BikeIdIterator;
import iterator.IBikeShop;
import iterator.Iterator;

public class EbikeShop implements IBikeShop {
	private static EbikeShop uniqueInstance;
	int quantity;
	BikeType type;
	int counter = 1;
	private List<Bike> bikes = new ArrayList<Bike>();

	private EbikeShop() {
	}

	public static synchronized EbikeShop getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new EbikeShop();
		}
		return uniqueInstance;
	}

	Map<BikeType, String> models = new HashMap<>();
	{
		models.put(BikeType.MTB, "Merida Big.Seven 500");
		models.put(BikeType.Trekking, "Stevens C6X");
		models.put(BikeType.RoadBike, "Giant Defy 1");
	}
	Map<BikeType, ForWhom> forWhoms = new HashMap<>();
	{
		forWhoms.put(BikeType.MTB, ForWhom.Male);
		forWhoms.put(BikeType.Trekking, ForWhom.Male);
		forWhoms.put(BikeType.RoadBike, ForWhom.Female);
	}
	Map<BikeType, Double> price = new HashMap<>();
	{
		price.put(BikeType.MTB, (double) 25);
		price.put(BikeType.Trekking, (double) 27);
		price.put(BikeType.RoadBike, (double) 35);
	}

	// Creating example of bikes from Prototype
	public void createBikes(int quantity, BikeType type) {

	Bike bike = new Bike(0, type, models.get(type), forWhoms.get(type), price.get(type), new Battery(100), false,
				0);

	// Clonning and adding clones of prototype to list: bikes
	// Incrementing bikeId properties
		try {

			for (int i = 0; i < quantity; i++) {
				bikes.add(bike.clone());
				bikes.get(bikes.size() - 1).setBikeId(counter);
				counter++;
			}
		} catch (CloneNotSupportedException e) {

		}
	}

	@Override
	public List<Bike> getBikes() {
		return bikes;
	}

	@Override
	public Iterator createIterator(String IteratorType) {

		if ("available".equals(IteratorType)) {
			return new AvailableIterator(bikes);
		} else {
			return new BikeIdIterator(bikes);
		}

	}
}
