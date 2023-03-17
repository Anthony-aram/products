package com.products.products.controller;

import com.products.products.dto.LoginDto;
import com.products.products.dto.AuthenticationResponse;
import com.products.products.dto.RegisterDto;
import com.products.products.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping(value = "/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterDto registerDto) {
        return new ResponseEntity<>(authenticationService.register(registerDto), HttpStatus.CREATED);
    }

    @PostMapping(value = "/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody LoginDto registerRequest) {
        return ResponseEntity.ok(authenticationService.authenticate(registerRequest));
    }
}
