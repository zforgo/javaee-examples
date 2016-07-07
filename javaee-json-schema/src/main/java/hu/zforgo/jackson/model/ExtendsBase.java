package hu.zforgo.jackson.model;

public class ExtendsBase extends BaseObject {
	private String name;
	private boolean hasFriends;
	private float floatValue;

	private EnumObject enumerated;

	public ExtendsBase() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isHasFriends() {
		return hasFriends;
	}

	public void setHasFriends(boolean hasFriends) {
		this.hasFriends = hasFriends;
	}

	public float getFloatValue() {
		return floatValue;
	}

	public void setFloatValue(float floatValue) {
		this.floatValue = floatValue;
	}

	public EnumObject getEnumerated() {
		return enumerated;
	}

	public void setEnumerated(EnumObject enumerated) {
		this.enumerated = enumerated;
	}
}
