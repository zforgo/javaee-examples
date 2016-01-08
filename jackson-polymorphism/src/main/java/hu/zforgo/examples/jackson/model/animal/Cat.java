package hu.zforgo.examples.jackson.model.animal;

public class Cat extends Animal {

	private boolean naked;

	public boolean isNaked() {
		return naked;
	}

	public void setNaked(boolean naked) {
		this.naked = naked;
	}
}
