package net.haxjakt.springtest.repository.mongo;

import net.haxjakt.springtest.repository.entity.type.ResourceType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceTypeRepository extends MongoRepository<ResourceType, String> {
}
