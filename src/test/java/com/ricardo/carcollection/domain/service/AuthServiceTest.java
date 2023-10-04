package com.ricardo.carcollection.domain.service;

import com.ricardo.carcollection.core.security.TokenService;
import com.ricardo.carcollection.domain.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@SpringBootTest
public class AuthServiceTest {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthService authService;

    @Autowired
    private TokenService tokenService;

    @Test
    public void shouldAuthenticate_successfully() {
        String login = "john.doe";
        String password = "123";

        var usernamePassword = new UsernamePasswordAuthenticationToken(login, password);
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((User) auth.getPrincipal());

        Assertions.assertNotNull(token);

    }

    @Test
    public void shouldFail_onAuthenticate() {
        String login = "john.doe";
        String password = "1223";

        var usernamePassword = new UsernamePasswordAuthenticationToken(login, password);
        Assertions.assertThrows(BadCredentialsException.class, () -> {
            var auth = this.authenticationManager.authenticate(usernamePassword);
        });
    }

}
