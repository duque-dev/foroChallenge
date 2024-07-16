package com.alurachallenge.foro.controller;

import com.alurachallenge.foro.domain.mapper.ClientAuthDataDTO;
import com.alurachallenge.foro.domain.model.Client;
import com.alurachallenge.foro.infrastructure.service.JWTtokenDTO;
import com.alurachallenge.foro.infrastructure.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;
    @PostMapping
    public ResponseEntity userAuth(@RequestBody @Valid ClientAuthDataDTO clientAuthDataDTO){
        Authentication authToken = new UsernamePasswordAuthenticationToken(clientAuthDataDTO.userName(),clientAuthDataDTO.password());
        var clientAuth = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generateToke((Client) clientAuth.getPrincipal());
        return ResponseEntity.ok(new JWTtokenDTO(JWTtoken));
    }
}
