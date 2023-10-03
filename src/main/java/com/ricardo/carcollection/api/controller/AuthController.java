package com.ricardo.carcollection.api.controller;

import com.ricardo.carcollection.api.converter.UserConverter;
import com.ricardo.carcollection.api.model.LoginResponse;
import com.ricardo.carcollection.api.model.UserModel;
import com.ricardo.carcollection.api.model.input.AuthInput;
import com.ricardo.carcollection.core.security.TokenService;
import com.ricardo.carcollection.domain.entity.User;
import com.ricardo.carcollection.domain.service.AuthService;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthService authService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserConverter userConverter;

    @PostMapping("/signin")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity signIn(@RequestBody @Valid AuthInput input) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(input.getLogin(), input.getPassword());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((User) auth.getPrincipal());
        authService.signIn((User) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponse(token));
    }

    @GetMapping("/me")
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<UserModel> getUserInfo(@AuthenticationPrincipal User authenticatedUser) {
        User user = authService.findById(authenticatedUser.getId());
        return ResponseEntity.ok(userConverter.toModel(user));
    }

}
