package com.marcos.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.marcos.api.domain.User;
import com.marcos.api.dto.user.AuthenticationRequestDTO;
import com.marcos.api.infra.security.AuthenticationResponseDTO;
import com.marcos.api.infra.security.TokenService;


@RestController
@RequestMapping("/login")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<AuthenticationResponseDTO> login(
            @RequestBody @Valid AuthenticationRequestDTO dto) {
        Authentication authenticationToken =
                new UsernamePasswordAuthenticationToken(dto.username(), dto.password());
        Authentication authentication = manager.authenticate(authenticationToken);
        String tokenJwt = tokenService.generateToken((User) authentication.getPrincipal());
        return ResponseEntity.ok(new AuthenticationResponseDTO(tokenJwt));
    }
}
