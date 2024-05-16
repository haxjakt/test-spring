package net.haxjakt.springtest.controller.auth;

import lombok.RequiredArgsConstructor;
import net.haxjakt.springtest.controller.auth.request.AuthenticationRequest;
import net.haxjakt.springtest.controller.auth.request.RegisterRequest;
import net.haxjakt.springtest.controller.auth.response.AuthenticationResponse;
import net.haxjakt.springtest.service.auth.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> registerUser(
            @Validated @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> login(
            @Validated @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
