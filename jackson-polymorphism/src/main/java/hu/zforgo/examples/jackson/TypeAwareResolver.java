package hu.zforgo.examples.jackson;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder;

import java.util.Collection;

public class TypeAwareResolver extends StdTypeResolverBuilder {

    public TypeDeserializer buildTypeDeserializer(final DeserializationConfig config, final JavaType baseType, final Collection<NamedType> subtypes) {
        return new TypeAwareDeserializer(baseType, null, _typeProperty, _typeIdVisible, _defaultImpl);
    }
}
