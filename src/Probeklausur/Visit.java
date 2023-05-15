package Probeklausur;

public class Visit {
	private Field[] fields;

	public Visit(Field[] fields) throws IllegalArgumentException{
		
		if(fields.length <3) {
			this.fields = fields;

		}
		else
		{
			throw new IllegalArgumentException();
		}
		
	}
	
	public Field[] getfields() {
		return fields;
	}
	
	public int getValue() {
		int x =0;
		for(int i =0; i<fields.length ;i++) {
			x += fields[i].getValue();
		}
		return x;
	}
	
	public Field getLastField() {
		return fields[fields.length];
	}
	
}
