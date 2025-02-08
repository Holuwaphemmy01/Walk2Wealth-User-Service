package com.akinzo.Walk2WealthUserService.controller.registerController;

import com.akinzo.Walk2WealthUserService.dtos.request.UserRegisterRequest;
import com.akinzo.Walk2WealthUserService.service.register.UsersRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private  UsersRegisterService usersRegisterService;

    @PostMapping()
    public ResponseEntity<?> register(@RequestBody UserRegisterRequest userRegisterRequest) {

        try{
                String response = usersRegisterService.registerUser(userRegisterRequest);
                return ResponseEntity.status(200).body(response);
        } catch (Exception exception) {
            return ResponseEntity.status(400).body(exception.getMessage());
        }
    }

}
