package io.github.tatiramoos.quarkussocial.rest;

import io.github.tatiramoos.quarkussocial.domain.model.User;
import io.github.tatiramoos.quarkussocial.rest.dto.CreateUserRequest;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @POST
    @Transactional
    public Response createUser(CreateUserRequest userRequest ) {

        User user = new User();
        user.setAge(userRequest.getAge());
        user.setName(userRequest.getName());

        user.persist();

        return Response.ok(userRequest).build();
    }
    @GET
    public Response listAllUsers() {
        PanacheQuery<User> query = User.findAll();
        return Response.ok(query.list()).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response deleteUser(@PathParam("id") Long id) {
        User user = User.findById(id);

        if (user != null){
            user.delete();
        return Response.ok().build();
    }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    @PUT
    @Path("{id}")
    @Transactional
    public Response updateUser(@PathParam("id") Long id, CreateUserRequest userData ){
        User user = User.findById(id);

        if (user != null){
            user.setName(userData.getName());
            user.setAge(userData.getAge());
            return Response.ok().build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
