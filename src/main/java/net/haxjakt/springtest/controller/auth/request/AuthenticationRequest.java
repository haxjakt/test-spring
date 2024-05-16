package net.haxjakt.springtest.controller.auth.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AuthenticationRequest {
    @NotBlank
    private String email;

    @NotBlank
    private String password;
}
