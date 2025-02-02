package com.akinzo.Walk2WealthUserService.service.register;

import com.akinzo.Walk2WealthUserService.dtos.request.UserRegisterRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRegisterServiceImplTest {

    @Autowired
    private UserRegisterServiceImpl userRegisterService;

    @Test
    void testToThrowExceptionWhenFirstNameIsBlank(){
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setFirstName("");
        assertThrows(IllegalArgumentException.class, () -> userRegisterService.registerUser(userRegisterRequest));
    }

    @Test
    void testToThrowExceptionWhenLastNameIsBlank(){
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setFirstName("first name");
        userRegisterRequest.setLastName("");
        assertThrows(IllegalArgumentException.class, () -> userRegisterService.registerUser(userRegisterRequest));
    }

    @Test
    void testToThrowExceptionWhenEmailIsBlank(){
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setFirstName("first name");
        userRegisterRequest.setLastName("last name");
        userRegisterRequest.setEmail("");
        assertThrows(IllegalArgumentException.class, () -> userRegisterService.registerUser(userRegisterRequest));
    }

    @Test
    void testToThrowExceptionWhenEmailIsInvalid(){
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setFirstName("first name");
        userRegisterRequest.setLastName("last name");
        userRegisterRequest.setEmail("invalid");
        assertThrows(IllegalArgumentException.class, () -> userRegisterService.registerUser(userRegisterRequest));
    }

    @Test
    void testToThrowExceptionWhenPasswordIsEmptyOrBlank(){
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setFirstName("first name");
        userRegisterRequest.setLastName("last name");
        userRegisterRequest.setEmail("correct@gmail.com");
        userRegisterRequest.setPassword("");
        assertThrows(IllegalArgumentException.class, () -> userRegisterService.registerUser(userRegisterRequest));
    }
}