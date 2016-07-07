package hu.zforgo.jackson.app;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.customProperties.HyperSchemaFactoryWrapper;
import com.fasterxml.jackson.module.jsonSchema.customProperties.ValidationSchemaFactoryWrapper;
import com.fasterxml.jackson.module.jsonSchema.factories.SchemaFactoryWrapper;
import hu.zforgo.jackson.model.Embedded;
import hu.zforgo.jackson.model.ExtendsBase;
import hu.zforgo.jackson.model.HyperSchema;
import hu.zforgo.jackson.model.SimplePerson;
import hu.zforgo.jackson.model.Validated;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/schema")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class SchemaService {

	@GET
	public Response getSchema(@QueryParam("type") @DefaultValue("simplePerson") String type) throws JsonMappingException {
		Class klazz = null;
		switch (type) {
			case "simplePerson":
				klazz = SimplePerson.class;
				break;
			case "extends":
				klazz = ExtendsBase.class;
				break;
			case "embedded":
				klazz = Embedded.class;
				break;
			case "validated":
				klazz = Validated.class;
				break;
		}

		ObjectMapper m = new ObjectMapper();
		ValidationSchemaFactoryWrapper visitor = new ValidationSchemaFactoryWrapper();
		m.acceptJsonFormatVisitor(m.constructType(klazz), visitor);
		JsonSchema jsonSchema = visitor.finalSchema();
		return Response.ok(jsonSchema).build();
	}

	@GET
	@Path("/hyper")
	public Response hyperSchema() throws JsonMappingException {
		HyperSchemaFactoryWrapper visitor  = new HyperSchemaFactoryWrapper();
		ObjectMapper mapper = new ObjectMapper();
		mapper.acceptJsonFormatVisitor(HyperSchema.class, visitor);
		JsonSchema jsonSchema = visitor.finalSchema();
		return Response.ok(jsonSchema).build();
	}
}
