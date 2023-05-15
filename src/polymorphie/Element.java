package polymorphie;

public class Element {

	public static final int solid =1;
	public static final int liquid=2;
	public static final int gas =3;
	
	private String name;
	private String symbol;
	private int ordnungszahl;
	private char shell;
	private int aggregatszustand;

	private boolean hauptgruppe;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public int getOrdnungszahl() {
		return ordnungszahl;
	}

	public void setOrdnungszahl(int ordnungszahl) {
		this.ordnungszahl = ordnungszahl;
	}

	public char getShell() {
		return shell;
	}

	public void setShell(char shell) {
		this.shell = shell;
	}

	public int getAggregatszustand() {
		return aggregatszustand;
	}

	public void setAggregatszustand(int aggregatszustand) {
		this.aggregatszustand = aggregatszustand;
	}

	public boolean isHauptgruppe() {
		return hauptgruppe;
	}

	public void setHauptgruppe(boolean hauptgruppe) {
		this.hauptgruppe = hauptgruppe;
	}

	@Override
	public String toString() {
		return name + ": symbol=" + symbol + ", ordnungszahl=" + ordnungszahl + ", shell=" + shell
				+ ", aggregatszustand=" + aggregatszustand + ", hauptgruppe=" + hauptgruppe + "]";
	}

	public Element(String name, String symbol, int ordnungszahl, char shell, int aggregatszustand, boolean hauptgruppe) {
		this.name = name;
		this.symbol = symbol;
		this.ordnungszahl = ordnungszahl;
		this.shell = shell;
		this.aggregatszustand = aggregatszustand;
		this.hauptgruppe = hauptgruppe;
	}
	
	public boolean equals(Object o) {
		if(o instanceof Element && ((Element) o).getOrdnungszahl() ==this.ordnungszahl)
			return true;
		else
			return false;
	}
	
	
	
	

}
