package org.acme.adapters.in.rest;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.domain.model.Person;
import org.acme.domain.ports.in.PersonUseCase;

import java.util.List;

@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResource {

    private final PersonUseCase service;

    public PersonResource(PersonUseCase service) {
        this.service = service;
    }

    @GET
    public List<Person> getAll() {
        return service.getAll();
    }

    @GET
    @Path("/{id}")
    public Person get(@PathParam("id") Long id) {
        return service.getById(id);
    }

    @POST
    public Response create(Person person) {
        Person created = service.create(person);
        return Response.status(Response.Status.CREATED).entity(created).build();
    }

    @PUT
    @Path("/{id}")
    public Person update(@PathParam("id") Long id, Person person) {
        return service.update(id, person);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        service.delete(id);
    }
}
