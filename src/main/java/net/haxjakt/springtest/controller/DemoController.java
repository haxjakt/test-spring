package net.haxjakt.springtest.controller;

import lombok.AllArgsConstructor;
import net.haxjakt.springtest.service.DemoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@AllArgsConstructor
public class DemoController {
    private final DemoService demoService;
    @GetMapping("/counter")
    ResponseEntity<String> demo() {
        return ResponseEntity.ok(demoService.fetchAndIncrementCounter());
    }
}
