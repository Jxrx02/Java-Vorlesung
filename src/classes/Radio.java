package classes;

public class Radio {

	boolean on;
	int volume;
	double frequency;
	public boolean isOn() {
		return on;
	}
	public void setOn(boolean on) {
		this.on = on;
	}
	public int getVolume() {
		return this.volume;
	}
	public void setVolume(int volume) {
		if(volume<0)
			this.volume =0;
		else if(volume>10)
			this.volume = 10;
		else this.volume = volume;
	}
	public double getFrequency() {
		return frequency;
	}
	public void setFrequency(double frequency) {
		if(frequency < 85) this.frequency = 85;
		else if(frequency>110) this.frequency = 110;
		else this.frequency = frequency;
	}
	public Radio() {
		this(true,5,99.9);
	}
	public Radio(boolean on, int volume, double frequency) {
		super();
		this.setOn(on);
		this.setVolume(volume);
		this.setFrequency(frequency);
	}
	@Override
	public String toString() {
		return "Radio [on=" + on + ", volume=" + volume + ", frequency=" + frequency + "]";
	}
	
	public void incVolume() {
		if(this.isOn())
			this.setVolume(this.getVolume()+1);
	}
	public void decVolume() {
		if(this.isOn())
			this.setVolume(this.getVolume()-1);
	}
	
	public void turnOn() {
		this.setOn(true);
	}
	public void turnOff() {
		this.setOn(false);
	}
	
	
	public static void main(String[] args) {
		Radio sony = new Radio(true,9,30);
		System.out.println(sony);
		sony.incVolume();
		System.out.println(sony);
		sony.incVolume();
		System.out.println(sony);
		
	}

	
	
}
