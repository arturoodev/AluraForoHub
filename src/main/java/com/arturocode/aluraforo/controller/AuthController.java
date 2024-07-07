package com.arturocode.aluraforo.controller;

import com.arturocode.aluraforo.entity.user.DataUserAuthentication;
import com.arturocode.aluraforo.entity.user.User;
import com.arturocode.aluraforo.security.DataJwtToken;
import com.arturocode.aluraforo.security.TokenService;
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
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity authUser(@RequestBody @Valid DataUserAuthentication dataUserAuthentication){
        Authentication authToken = new UsernamePasswordAuthenticationToken(dataUserAuthentication.username(),
                dataUserAuthentication.password());

        var userAuthenticated = authenticationManager.authenticate(authToken);
        var jwtToken = tokenService.generateToken((User) userAuthenticated.getPrincipal());
        return ResponseEntity.ok(new DataJwtToken(jwtToken));
    }
}
