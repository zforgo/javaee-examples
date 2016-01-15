package hu.zforgo.examples.jackson.rest;

import hu.zforgo.examples.jackson.model.animal.Animal;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/sample")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class SampleService {

	@POST
	public Response animalTest(List<Animal> animals) {
		return Response.ok().build();
	}
}
