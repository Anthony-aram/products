package com.products.products.service;

import com.products.products.dto.AuthenticationResponse;
import com.products.products.dto.LoginDto;
import com.products.products.dto.RegisterDto;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterDto registerDto);

    AuthenticationResponse authenticate(LoginDto loginDto);
}
