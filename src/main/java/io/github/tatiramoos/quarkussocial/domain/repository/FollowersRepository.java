package io.github.tatiramoos.quarkussocial.domain.repository;

import io.github.tatiramoos.quarkussocial.domain.model.Followers;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FollowersRepository implements PanacheRepository<Followers> {
}
