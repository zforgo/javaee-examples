package hu.zforgo.examples.jackson.model.animal;

public class Bird extends Animal {
	private String wingspan;

	public String getWingspan() {
		return wingspan;
	}

	public Bird setWingspan(String wingspan) {
		this.wingspan = wingspan;
		return this;
	}
}
