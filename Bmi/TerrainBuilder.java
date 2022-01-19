package builder;



public class TerrainBuilder extends VehicleBuilder {
	private String type = "terrain";
	private int pojemnosc = 2500;
	private int ileDrzwi = 3;
	private Engine engine;

	@Override
	public VehicleBuilder setType(String type) {
		this.type = type;
		return this;
	}

	@Override
	public VehicleBuilder setPojemnosc(int pojemnosc) {
		this.pojemnosc = pojemnosc;
		return this;
	}

	@Override
	public VehicleBuilder setileDrzwi(int ileDrzwi) {
		this.ileDrzwi = ileDrzwi;
		return this;
	}

	@Override
	public VehicleBuilder setEngine(Engine engine) {
		this.engine = engine;
		return this;
	}

}
