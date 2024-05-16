package net.haxjakt.springtest.service.auth;

import lombok.RequiredArgsConstructor;
import net.haxjakt.springtest.controller.auth.request.AuthenticationRequest;
import net.haxjakt.springtest.controller.auth.request.RegisterRequest;
import net.haxjakt.springtest.controller.auth.response.AuthenticationResponse;
import net.haxjakt.springtest.repository.mongo.UserRepository;
import net.haxjakt.springtest.repository.entity.auth.Role;
import net.haxjakt.springtest.repository.entity.auth.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private static final Logger sLogger = LoggerFactory.getLogger(AuthenticationService.class);

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        sLogger.debug("Trying to authenticate user: " + request.getEmail());
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
        ));
        sLogger.info("Authenticated user: " + request.getEmail());
        var user = repository.findByUsername(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
