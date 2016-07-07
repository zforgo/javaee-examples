package hu.zforgo.jackson.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class Validated extends BaseObject implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull
	private String name;

	@Size(max = 15)
	private String length;

	@NotNull
	@Size(min = 2, max = 30)
	private String mandatoryLength;

	@Min(100)
	@Max(5000)
	private Long longValue;

	public Validated() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getMandatoryLength() {
		return mandatoryLength;
	}

	public void setMandatoryLength(String mandatoryLength) {
		this.mandatoryLength = mandatoryLength;
	}

	public Long getLongValue() {
		return longValue;
	}

	public void setLongValue(Long longValue) {
		this.longValue = longValue;
	}
}
