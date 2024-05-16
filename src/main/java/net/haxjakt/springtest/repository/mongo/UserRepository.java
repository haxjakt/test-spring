package net.haxjakt.springtest.repository.mongo;

import net.haxjakt.springtest.repository.entity.auth.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(final String email);

    Optional<User> findByUsername(final String username);
}
