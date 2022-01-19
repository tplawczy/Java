package shop;

import java.util.ArrayList;
import java.util.List;

import iterator.AvailableIterator;
import iterator.BikeIdIterator;
import iterator.Iterator;
import observer.IObserver;

public class Customer implements IObserver {
	String name;
	public List<Bike> rentedBikes = new ArrayList<Bike>();
	double cash = 40;

	EbikeShop ebikeShop = EbikeShop.getInstance();

	public Customer(String name) {
		this.name = name;
	}

	public void rentBike(int id) {
		Iterator bikeIdIterator = ebikeShop.createIterator("bikeId");
		if (bikeIdIterator.nextBike(id) != null) {
			bikeIdIterator.currentBike().setRented(true);
			rentedBikes.add(bikeIdIterator.currentBike());

		}
	}

	public void askForAvailableBikes() {

		Iterator availableIteratorId = ebikeShop.createIterator("available");
		while (!availableIteratorId.isLastBike()) {
			if (availableIteratorId.nextBike() != null) {
				System.out.println("Available Bikes: " + availableIteratorId.currentBike().getBikeId() + " "
						+ availableIteratorId.currentBike().getModel());
			}
		}
	}

	public int getBikeIndex(int id) {
		Bike bike = null;
		Iterator bikeIdIterator = ebikeShop.createIterator("bikeId");
			if (bikeIdIterator.nextBike(id) != null) {
				bike = bikeIdIterator.currentBike();
			}
		return ebikeShop.getBikes().indexOf(bike);
	}

	public void returnBike() {
		while (!rentedBikes.isEmpty()) {
			rentedBikes.remove(0).setRented(false);
		}
	}

	public void ride(int kilometers) {
		rentedBikes.iterator().next().getBattery().disCharge(kilometers);
		this.cash -= kilometers * 0.1;
	}

	@Override
	public void update(int charge) {
		System.out.println(name + " got noticed: Battery charge level is: " + charge + "%");

	}

	public List<Bike> getRentedBikes() {
		return rentedBikes;
	}

	public double getCash() {
		return cash;
	}

}
