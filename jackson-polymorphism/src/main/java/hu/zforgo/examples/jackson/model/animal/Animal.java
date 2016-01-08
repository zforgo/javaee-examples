package hu.zforgo.examples.jackson.model.animal;

import hu.zforgo.examples.jackson.model.Typed;

public abstract class Animal extends Typed {
	public enum Classification {
		Pisces,
		Amphibia,
		Reptilia,
		Aves,
		Mammalia
	}

	protected  Classification classification;

	public Classification getClassification() {
		return classification;
	}

	public void setClassification(Classification classification) {
		this.classification = classification;
	}
}
