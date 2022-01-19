package shop;



import decorator.AbstractBike;
import decorator.HelmetDecorator;
import decorator.TrailerDecorator;
import enums.BikeType;


public class Main {
	public static void main(String[] args) {
		
		
//Creating Objects using Prototype---------------------------------------------
		
		EbikeShop ebikeShop = EbikeShop.getInstance();
	    ebikeShop.createBikes(2, BikeType.MTB);		
		ebikeShop.createBikes(2, BikeType.Trekking);
		ebikeShop.createBikes(2, BikeType.RoadBike);
		System.out.println("------------------------PrototypeTest--------------------------");
		System.out.println("List of created bikes");
		System.out.println(EbikeShop.getInstance().getBikes().toString());
		
//Display available bikes to rent using Iterator-------------------------------
		
		Customer customer = new Customer("Tomek");	
		System.out.println("------------------------IteratorTest--------------------------");
		System.out.println("List of available bikes");
		customer.askForAvailableBikes();
		System.out.println("\n");
//Display available bikes after renting bike id 2		
		customer.rentBike(2);
		System.out.println("List of available bikes after renting bike with id 2 \n");
		customer.askForAvailableBikes();
		System.out.println("\nRented bike:\n"+customer.rentedBikes.toString()+"\n");
		customer.returnBike();
		
	
//Display summary of rent with decorated class------------------------------------------
		customer.rentBike(3);
		customer.rentBike(5);	
		AbstractBike bike = ebikeShop.getBikes().get(3);
		AbstractBike bike1 = ebikeShop.getBikes().get(5);
		System.out.println("------------------------DecoratorTest--------------------------");
	    System.out.println(String.format("Rental details for: %s. Total cost: %s.", bike.getModel() ,bike.getPrice()));
	    System.out.println(String.format("Rental details for: %s. Total cost: %s.", bike1.getModel(), bike1.getPrice()));	
		bike = new HelmetDecorator(bike);
		bike = new TrailerDecorator(bike);
		bike1 = new HelmetDecorator(bike1);
	    System.out.println(String.format("Rental details for: %s. Total cost: %s.", bike.getModel(), bike.getPrice()));
	    System.out.println(String.format("Rental details for: %s. Total cost: %s.", bike1.getModel(), bike1.getPrice()));
		//customer.returnBike();
	
		
	
//Display Observer notifications------------------------------------------
	
	    Customer ania = new Customer("Ania");	
	    Customer gosia = new Customer("Gosia");	
		System.out.println("------------------------ObserverTest--------------------------");
	    ebikeShop.getBikes().get(gosia.getBikeIndex(2)).getBattery().register(gosia);	 
	    System.out.println("Ania rents a bike id 2");
	    ania.rentBike(2);
	    System.out.println("Ania ride 13 km");
	    ania.ride(13);
	    System.out.println("Ania ride 30 km");
	    ania.ride(30);
	    ebikeShop.getBikes().get(gosia.getBikeIndex(2)).getBattery().unRegister(gosia);
	    ania.ride(1);
	    
//Display Facade------------------------------------------	    
		System.out.println("------------------------FacadeTest--------------------------");
		System.out.println("Ania want to rent a bike with id 3");
		System.out.println("Ania cash:" + ania.getCash());
	    Facade facade = new Facade();
	    System.out.println("Is renting possible?  "+ facade.answer(facade.isRentPossible(ania,3)));
		System.out.println("Ania returns bike 2");
		ania.returnBike();
		System.out.println("Is renting possible?  "+facade.answer(facade.isRentPossible(ania,3)));
		System.out.println("Customer returns bike 3");
		customer.returnBike();
		System.out.println("Is renting possible?  "+facade.answer(facade.isRentPossible(ania,3)));
	    
	  
	}
}
	