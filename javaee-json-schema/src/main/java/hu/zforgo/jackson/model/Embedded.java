package hu.zforgo.jackson.model;


import java.io.Serializable;

public class Embedded extends BaseObject implements Serializable {

	private static final long serialVersionUID = 1L;

	private ExtendsBase extendsBase;

	public Embedded() {
	}

	public ExtendsBase getExtendsBase() {
		return extendsBase;
	}

	public void setExtendsBase(ExtendsBase extendsBase) {
		this.extendsBase = extendsBase;
	}
}
