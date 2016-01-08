package hu.zforgo.examples.jackson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import hu.zforgo.examples.jackson.model.TypeAware;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;

@Startup
@Singleton
public class AppContext {

    private static volatile Map<Class<TypeAware>, List<TypeDescriptor>> typeMap;

    @PostConstruct
    public void init() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        URL c = getClass().getClassLoader().getResource("typeinfo.json");
        typeMap = mapper.readValue(c, new TypeReference<Map<Class<TypeAware>, List<TypeDescriptor>>>() {});
		System.out.printf("valami");
	}

    public static Map<Class<TypeAware>, List<TypeDescriptor>> getTypeMap() {
        return typeMap;
    }
}
