package builder;

public class Main {

    public static void main(String[] args) {
        final Vehicle vehicle = new VehicleBuilder()
                .setEngine(new Engine("diesel",5))
                .setBrand("Renault")
                .setModel("Clio")
                .setBodywork("combi") 
                .setAccessories("AC")
                .setAccessories("Navigation")
                .createVehicle();
        		

        System.out.println("vehicle=" + vehicle);   
      
    }
}
