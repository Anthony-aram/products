package com.products.products.service;

import com.products.products.dto.LoginDto;
import com.products.products.dto.RegisterDto;

public interface AuthService {
    String login(LoginDto loginDto);

    String register(RegisterDto registerDto);
}
