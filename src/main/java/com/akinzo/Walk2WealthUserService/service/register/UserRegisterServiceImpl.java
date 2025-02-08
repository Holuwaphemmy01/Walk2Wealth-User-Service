package com.akinzo.Walk2WealthUserService.service.register;

import com.akinzo.Walk2WealthUserService.dtos.request.UserRegisterRequest;
import com.akinzo.Walk2WealthUserService.model.Users;
import com.akinzo.Walk2WealthUserService.repository.UsersRepository;
import com.akinzo.Walk2WealthUserService.service.email.EmailValidator;
import com.akinzo.Walk2WealthUserService.service.mapper.RegisterMapper;
import com.akinzo.Walk2WealthUserService.service.password.PasswordValidator;
import com.akinzo.Walk2WealthUserService.service.register.hashPassword.HashPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserRegisterServiceImpl implements UsersRegisterService{


    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private RegisterMapper registerMapper;

    @Autowired
    private HashPassword hashPassword;



    @Override
    public String registerUser(UserRegisterRequest userRegisterRequest) {
        if(userRegisterRequest.getFirstName().isEmpty() || userRegisterRequest.getFirstName().isBlank()) throw new IllegalArgumentException("First name cannot be empty");
        if(userRegisterRequest.getLastName().isEmpty() || userRegisterRequest.getLastName().isBlank()) throw new IllegalArgumentException("Last name cannot be empty");
        if(userRegisterRequest.getEmail().isEmpty() || userRegisterRequest.getEmail().isBlank()) throw new IllegalArgumentException("Email cannot be empty");
        if(!EmailValidator.validateEmail(userRegisterRequest.getEmail())) throw new IllegalArgumentException("Invalid email");
        if(userRegisterRequest.getPassword().isEmpty() || userRegisterRequest.getPassword().isBlank()) throw new IllegalArgumentException("Password cannot be empty");
        if(!PasswordValidator.validatePassword(userRegisterRequest.getPassword())) throw new IllegalArgumentException("Invalid password");
        if(userRegisterRequest.getUsername().isEmpty() || userRegisterRequest.getUsername().isBlank()) throw new IllegalArgumentException("Username cannot be empty");
        if(userRegisterRequest.getUsername().contains(" ")) throw new IllegalArgumentException("Username cannot contain spaces");


        Users users = usersRepository.findByEmail(userRegisterRequest.getEmail());
        if(users != null) throw new IllegalArgumentException("Email already in use ");

        Users responseUsername = usersRepository.findByUsername(userRegisterRequest.getUsername());
        if(responseUsername != null) throw new IllegalArgumentException("username is already taken");

        Users user = new Users();
        Users response = registerMapper.registerMapper(userRegisterRequest, user);
        String stringPassword = hashPassword.hash(response.getPassword());
        response.setPassword(stringPassword);
        Users saveResponse = usersRepository.save(response);
        if (saveResponse == null) throw new IllegalArgumentException("User could not be saved");
        return "Registration successful";
    }
}
