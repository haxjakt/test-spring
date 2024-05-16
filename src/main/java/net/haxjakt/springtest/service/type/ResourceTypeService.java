package net.haxjakt.springtest.service.type;

import lombok.AllArgsConstructor;
import net.haxjakt.springtest.repository.mongo.ResourceTypeRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ResourceTypeService {
    private final ResourceTypeRepository resourceTypeRepository;
}
