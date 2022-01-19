package builder;

/**
 * TODO: Document this class / interface here
 *
 * @since v8.0
 */
public class Engine  {
    private String fuelType;
    private int cylinders;
    
    public String getFuelType() {
		return fuelType;
	}



	public int getCylinders() {
		return cylinders;
	}



	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}



	public void setCylinders(int cylinders) {
		this.cylinders = cylinders;
	}

    public Engine(final String fuelType, final int cylinders) {
        this.fuelType = fuelType;
        this.cylinders = cylinders;
    }

  

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Engine{");
        sb.append("fuelType='").append(fuelType).append('\'');
        sb.append("cylinders='").append(cylinders).append('\'');      
        sb.append('}');
        return sb.toString();
    }



	
}
