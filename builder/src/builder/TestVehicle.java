package builder;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;



class TestVehicle {

	@Test
	public final void TestVehicle() { 
		Vehicle vehicle = new VehicleBuilder()
	                .setEngine(new Engine("diesel",5))
                .setBrand("Renault")
                .setModel("Clio")
                .setBodywork("combi")
                .setAccessories("AC")
                .setAccessories("Navigation")
                .createVehicle();
        		

		Assert.assertEquals("Renault",vehicle.getBrand());
		Assert.assertEquals("Clio",vehicle.getModel());
		Assert.assertEquals("combi",vehicle.getBodywork());
		Assert.assertEquals("diesel",vehicle.getEngine().getFuelType());
		Assert.assertEquals("[AC, Navigation]",vehicle.getAccessories().toString());
		
	}

}
