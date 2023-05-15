package polymorphie;

public class PeriodicTable {

	private Element[] elements = new Element[119];
	
	public void addElement(Element e) {
		if(!hasElement(e.getOrdnungszahl()))
			elements[e.getOrdnungszahl()] = e;
	}
	public boolean hasElement(int o) {
		if(elements[o] == null)
			return false;
		return true;
	}
	public Element getElement(int o) {
		return elements[o];
	}
	public Element[] getMetals() {
		Element metal[]=new Element[119];
		for(int i =0; i< elements.length;i++) {
			if(elements[i] instanceof Metal) {
				metal[i] = elements[i];
			}
		}
		return metal;
	}
	
	public void print () {
		System.out.println("Elemente:");
		for (Element e : elements)
			if (e != null)
				System.out.println(e);	
	}
	
	public static void main(String[] args) {
		PeriodicTable pt = new PeriodicTable();
		pt.addElement(new Element("Wasserstoff", "H", 1, 'K', Element.gas, true));
		pt.addElement(new Element("Helium", "He", 2, 'K', Element.gas, true));

		pt.addElement(new Metal("Natrium", "Na", 11, 'M', Element.solid, true, false, 21E6));
		pt.addElement(new Metal("Eisen", "Fe", 26, 'N', Element.solid, false, false, 10.02E6));
		pt.addElement(new Metal("Germanium", "Ge", 32, 'N', Element.solid, false, true, 1.45));
		pt.addElement(new Element("Brom", "Br", 35, 'N', Element.liquid, true));
		pt.addElement(new Metal("Tellur", "Te", 52, 'O', Element.solid, true, true, 0.005));
		pt.addElement(new Metal("Gold", "Au", 79, 'P', Element.solid, false, false, 44E6));

		pt.print();


		System.out.println("\nMetalle:");
		for (Element e : pt.getMetals())
			if(e!=null)
				System.out.println(e);

		System.out.println("\nGold:");
		System.out.println(pt.getElement(79));

	}

}
