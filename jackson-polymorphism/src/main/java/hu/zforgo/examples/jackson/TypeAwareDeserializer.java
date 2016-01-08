package hu.zforgo.examples.jackson;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import com.fasterxml.jackson.databind.type.SimpleType;
import hu.zforgo.examples.jackson.model.TypeAware;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class TypeAwareDeserializer extends AsPropertyTypeDeserializer {

	public TypeAwareDeserializer(JavaType bt, TypeIdResolver idRes, String typePropertyName, boolean typeIdVisible, Class<?> defaultImpl) {
		super(bt, idRes, typePropertyName, typeIdVisible, defaultImpl);
	}

	public TypeAwareDeserializer(JavaType bt, TypeIdResolver idRes, String typePropertyName, boolean typeIdVisible, Class<?> defaultImpl, JsonTypeInfo.As inclusion) {
		super(bt, idRes, typePropertyName, typeIdVisible, defaultImpl, inclusion);
	}

	public TypeAwareDeserializer(AsPropertyTypeDeserializer src, BeanProperty property) {
		super(src, property);
	}

	@Override
	public TypeDeserializer forProperty(final BeanProperty prop) {
		return (prop == _property) ? this : new TypeAwareDeserializer(this, prop);
	}

	@Override
	public Object deserializeTypedFromObject(
			final JsonParser jp, final DeserializationContext ctxt) throws IOException {
		JsonNode node = jp.readValueAsTree();
		Class<?> subType = findSubType(node);
		JavaType type = SimpleType.construct(subType);

		JsonParser jsonParser = new TreeTraversingParser(node, jp.getCodec());
		if (jsonParser.getCurrentToken() == null) {
			jsonParser.nextToken();
		}
		if (_baseType != null && _baseType.getClass() == type.getClass()) {
			type = _baseType.narrowBy(type.getRawClass());
		}
		JsonDeserializer<Object> deser = ctxt.findContextualValueDeserializer(type, _property);
		return deser.deserialize(jsonParser, ctxt);
	}

	protected Class<TypeAware> findSubType(JsonNode node) {
		String type = node.get("type").asText();
		List<TypeDescriptor> all = AppContext.getTypeMap().getOrDefault(_baseType, Collections.emptyList());
		return all.stream().filter(s -> type.equals(s.getType())).findFirst()
				.orElseThrow(() -> new IllegalArgumentException(String.format("unrecognized type [%s] for %s", type, _baseType))).getImpl();
	}
}
