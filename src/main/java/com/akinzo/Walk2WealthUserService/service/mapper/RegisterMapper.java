package com.akinzo.Walk2WealthUserService.service.mapper;

import com.akinzo.Walk2WealthUserService.dtos.request.UserRegisterRequest;
import com.akinzo.Walk2WealthUserService.model.Users;
import org.springframework.stereotype.Service;

@Service
public class RegisterMapper {

    public  Users registerMapper(UserRegisterRequest userRegisterRequest, Users users) {
        users.setFirstName(userRegisterRequest.getFirstName());
        users.setLastName(userRegisterRequest.getLastName());
        users.setEmail(userRegisterRequest.getEmail());
        users.setPassword(userRegisterRequest.getPassword());
        users.setUsername(userRegisterRequest.getUsername());
        return users;
    }
}
