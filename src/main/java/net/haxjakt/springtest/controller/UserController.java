package net.haxjakt.springtest.controller;

import net.haxjakt.springtest.dto.UserResponseDTO;
import net.haxjakt.springtest.service.auth.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // TODO what is response entity
    @PostMapping
    public ResponseEntity<UserResponseDTO> registerUser(
            @RequestParam(name = "username") String username,
            @RequestParam(name = "email") String email) {
        return new ResponseEntity<>(userService.addUser(username, email), HttpStatus.CREATED);
    }

    @GetMapping
    public UserResponseDTO getUserById(@RequestParam(name = "id") String id) {
        return userService.getUserById(id);
    }
}
