package polymorphie;

public class Metal extends Element{

	
	private boolean metalloid;
	private double conductivity;
	public boolean isMetalloid() {
		return metalloid;
	}
	public void setMetalloid(boolean metalloid) {
		this.metalloid = metalloid;
	}
	public double getConductivity() {
		return conductivity;
	}
	public void setConductivity(double conductivity) {
		this.conductivity = conductivity;
	}
	
	
	
	public Metal(String name, String symbol, int ordnungszahl, char shell, int aggregatszustand, boolean hauptgruppe) {
		super(name, symbol, ordnungszahl, shell, aggregatszustand, hauptgruppe);
		// TODO Auto-generated constructor stub
	}
	public Metal(String name, String symbol, int ordnungszahl, char shell, int aggregatszustand, boolean hauptgruppe,
			boolean metalloid, double conductivity) {
		super(name, symbol, ordnungszahl, shell, aggregatszustand, hauptgruppe);
		this.metalloid = metalloid;
		this.conductivity = conductivity;
	}

    @Override
    public String toString() {
        return super.toString()+", "+metalloid+", "+conductivity;
    }


	
	
	
	
}
