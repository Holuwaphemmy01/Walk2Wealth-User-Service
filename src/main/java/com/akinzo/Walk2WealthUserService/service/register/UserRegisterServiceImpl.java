package com.akinzo.Walk2WealthUserService.service.register;

import com.akinzo.Walk2WealthUserService.dtos.request.UserRegisterRequest;
import com.akinzo.Walk2WealthUserService.service.email.EmailValidator;
import org.springframework.stereotype.Service;

@Service
public class UserRegisterServiceImpl implements UsersRegisterService{


    @Override
    public String registerUser(UserRegisterRequest user) {
        if(user.getFirstName().isEmpty() || user.getFirstName().isBlank()) throw new IllegalArgumentException("First name cannot be empty");
        if(user.getLastName().isEmpty() || user.getLastName().isBlank()) throw new IllegalArgumentException("Last name cannot be empty");
        if(user.getEmail().isEmpty() || user.getEmail().isBlank()) throw new IllegalArgumentException("Email cannot be empty");
        if(!EmailValidator.validateEmail(user.getEmail())) throw new IllegalArgumentException("Invalid email");
        if(user.getPassword().isEmpty() || user.getPassword().isBlank()) throw new IllegalArgumentException("Password cannot be empty");
        return "";
    }
}
