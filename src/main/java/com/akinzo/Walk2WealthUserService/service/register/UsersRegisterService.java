package com.akinzo.Walk2WealthUserService.service.register;

import com.akinzo.Walk2WealthUserService.dtos.request.UserRegisterRequest;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

public interface UsersRegisterService {
    String registerUser(UserRegisterRequest user);
}
