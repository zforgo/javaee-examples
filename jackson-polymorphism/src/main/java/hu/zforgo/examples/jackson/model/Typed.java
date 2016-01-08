package hu.zforgo.examples.jackson.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonTypeResolver;
import hu.zforgo.examples.jackson.TypeAwareResolver;

@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
@JsonTypeResolver(TypeAwareResolver.class)
public abstract class Typed implements TypeAware {
	protected String type;

	@Override
	public String getType() {
		return type;
	}

	@Override
	public void setType(String type) {
		this.type = type;
	}
}
