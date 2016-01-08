package hu.zforgo.examples.jackson.model.criteria;

public class Gender extends Criteria {
	public enum Sex {
		MALE,
		FEMALE
	}

	private Sex gender;

	public Sex getGender() {
		return gender;
	}

	public void setGender(Sex gender) {
		this.gender = gender;
	}
}
