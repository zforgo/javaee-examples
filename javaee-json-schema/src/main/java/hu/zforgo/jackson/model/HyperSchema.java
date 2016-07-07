package hu.zforgo.jackson.model;

import com.fasterxml.jackson.module.jsonSchema.annotation.JsonHyperSchema;
import com.fasterxml.jackson.module.jsonSchema.annotation.Link;

import java.io.Serializable;

@JsonHyperSchema(
		links = {
				@Link(href = "{id}/person", rel="person", targetSchema = SimplePerson.class)
		}
)
public class HyperSchema extends BaseObject implements Serializable {
	private static final long serialVersionUID = 1L;

	private String simpleField;

	public HyperSchema() {
	}

	public String getSimpleField() {
		return simpleField;
	}

	public void setSimpleField(String simpleField) {
		this.simpleField = simpleField;
	}
}
