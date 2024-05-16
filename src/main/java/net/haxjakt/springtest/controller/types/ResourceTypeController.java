package net.haxjakt.springtest.controller.types;

import lombok.AllArgsConstructor;
import net.haxjakt.springtest.service.type.ResourceTypeService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ResourceTypeController {
    private final ResourceTypeService resourceTypeService;
}
