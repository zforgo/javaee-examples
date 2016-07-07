package hu.zforgo.jackson.model;

import java.io.Serializable;

public class BaseObject implements Serializable {
	private static final long serialVersionUID = 1L;

	private long id;

	public BaseObject() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
