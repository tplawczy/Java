package shop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import decorator.AbstractBike;
import decorator.HelmetDecorator;
import decorator.TrailerDecorator;
import enums.BikeType;

class EBikeShopTest {

	
	@Test
	public void singletonTest() {
//Testing Singleton Class - EbikeShop
		
		EbikeShop ebikeShop =  EbikeShop.getInstance();
		EbikeShop ebikeShop1= EbikeShop.getInstance();
		assertEquals(ebikeShop, ebikeShop1);
	}

	@Test
	public void prototypTest() {		
// Creating Objects using Prototype and placing them in the list "bikes"
		
		EbikeShop ebikeShop = EbikeShop.getInstance();
		ebikeShop.createBikes(3, BikeType.MTB);
		ebikeShop.createBikes(3, BikeType.Trekking);
		ebikeShop.createBikes(3, BikeType.RoadBike);
		assertEquals(9, EbikeShop.getInstance().getBikes().size());
		System.out.println("------------------------Prototype Test--------------------------");
		System.out.println("List of created bikes");
		System.out.println(ebikeShop.getBikes().toString());
	}
	@Test 
	public void iteratorTest() {	
//Display available bikes to rent using Iterator
		System.out.println("------------------------Iterator Test--------------------------");
		EbikeShop ebikeShop =EbikeShop.getInstance();
		Customer customer = new Customer("Tomek");	
		System.out.println("List of available bikes");
		//Display available bikes to rent using Iterator
		customer.askForAvailableBikes();	
		//Renting bike with identifier=2,5,7
		customer.rentBike(2);
		customer.rentBike(5);
		customer.rentBike(7);
		//testing rented bikes
		assertTrue(ebikeShop.getBikes().get(customer.getBikeIndex(2)).isRented());
		assertTrue(ebikeShop.getBikes().get(customer.getBikeIndex(5)).isRented());
		assertTrue(ebikeShop.getBikes().get(customer.getBikeIndex(7)).isRented());
		System.out.println("\nRenting bikes 2,5,7 \n");
		System.out.println("\nList of available bikes after renting bike with id 2,5,7 \n ");
		customer.askForAvailableBikes();
		customer.returnBike();
		System.out.println("\nCustomer returns bikes ");
		System.out.println("\nList of available bikes after renturning bikes \n ");
		customer.askForAvailableBikes();
		assertFalse(ebikeShop.getBikes().get(customer.getBikeIndex(2)).isRented());
		assertFalse(ebikeShop.getBikes().get(customer.getBikeIndex(5)).isRented());
		assertFalse(ebikeShop.getBikes().get(customer.getBikeIndex(7)).isRented());
		
		
	}
	@Test
	public void decoratorTest() {
//Testing Decorator Pattern 
		
		Customer customer = new Customer("Tomek");	
		EbikeShop ebikeShop =EbikeShop.getInstance();
		customer.rentBike(5);
		AbstractBike bike = ebikeShop.getBikes().get(5);
		System.out.println("------------------------Decorator Test--------------------------");
		System.out.println(String.format("Rental details for: %s. Total cost: %s.", bike.getModel(), bike.getPrice()));

		bike = new HelmetDecorator(bike);
		
		System.out.println(String.format("Rental details for: %s. Total cost: %s.", bike.getModel(), bike.getPrice()));
		
		bike = new TrailerDecorator(bike);
		
		System.out.println(String.format("Rental details for: %s. Total cost: %s.", bike.getModel(), bike.getPrice()));
		System.out.println("\n");
		
		assertEquals(bike.getPrice(),42);
		customer.returnBike();
	}		
	@Test
	public void observer_facadeTest() {
		EbikeShop ebikeShop =EbikeShop.getInstance();
	    Customer ania = new Customer("Ania");	
	    Customer gosia = new Customer("Gosia");	
	    
	    
	    System.out.println("------------------------Observer Test--------------------------");
	    System.out.println("Gosia subscribe to observe battery status of bike with id 2");
	    ebikeShop.getBikes().get(gosia.getBikeIndex(2)).getBattery().register(gosia);

	    System.out.println("Ania rents a bike id 2");
	    ania.rentBike(2);
	    System.out.println("Ania ride 13 km");
	    ania.ride(13);
	    System.out.println("Ania ride 30 km");
	    ania.ride(30);
	    ebikeShop.getBikes().get(gosia.getBikeIndex(2)).getBattery().unRegister(gosia);
	    ania.ride(1);
	    
	    
	    System.out.println("------------------------Facade Test--------------------------");
	    System.out.println("Ania want to rent a bike with id 3");
		System.out.println("Ania cash:" + ania.getCash() + " zl");
		Facade facade = new Facade();
		System.out.println("Ania has already rented bike with id 2");
		System.out.println("Is renting possible?  "+ facade.answer(facade.isRentPossible(ania,3)));
		System.out.println("Ania returns bike 2");
		ania.returnBike();
		System.out.println("Is renting possible?  "+facade.answer(facade.isRentPossible(ania,3)));
		assertTrue(true);
	}

}


