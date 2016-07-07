package hu.zforgo.jackson.model;

import java.io.Serializable;

public class SimplePerson implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String email;

	public SimplePerson() {
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}
}
