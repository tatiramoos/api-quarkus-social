package io.github.tatiramoos.quarkussocial.rest.dto;

import io.github.tatiramoos.quarkussocial.domain.repository.FollowersRepository;
import io.github.tatiramoos.quarkussocial.domain.repository.UserRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/users/{userId}/followers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FollowersResource {

    private FollowersRepository repository;
    private UserRepository userRepository;

    @Inject
    public FollowersResource(FollowersRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }
}
