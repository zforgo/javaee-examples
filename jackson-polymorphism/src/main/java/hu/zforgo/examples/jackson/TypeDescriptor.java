package hu.zforgo.examples.jackson;

import hu.zforgo.examples.jackson.model.TypeAware;

public class TypeDescriptor {

    private String type;
    private Class<TypeAware> impl;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Class<TypeAware> getImpl() {
        return impl;
    }

    public void setImpl(Class impl) {
        this.impl = impl;
    }
}
