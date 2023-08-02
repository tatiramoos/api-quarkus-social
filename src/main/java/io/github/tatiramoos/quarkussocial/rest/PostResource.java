package io.github.tatiramoos.quarkussocial.rest;

import io.github.tatiramoos.quarkussocial.domain.model.Post;
import io.github.tatiramoos.quarkussocial.domain.model.User;
import io.github.tatiramoos.quarkussocial.domain.repository.PostRepository;
import io.github.tatiramoos.quarkussocial.domain.repository.UserRepository;
import io.github.tatiramoos.quarkussocial.rest.dto.CreatePostRequest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/users/{userId}/posts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PostResource {

    private UserRepository userRepository;
    private PostRepository repository;

    @Inject
    public PostResource(UserRepository userRepository, PostRepository repository) {
        this.userRepository = userRepository;
        this.repository = repository;
    }

    @POST
    @Transactional
    public Response savePost(@PathParam("userId") Long userId, CreatePostRequest request){
        User user = userRepository.findById(userId);
        if (user == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        Post post = new Post();
        post.setText(request.getText());
        post.setUser(user);

        repository.persist(post);

        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    public Response listPost(@PathParam("userId") Long userId){
        return Response.ok().build();
    }
}
