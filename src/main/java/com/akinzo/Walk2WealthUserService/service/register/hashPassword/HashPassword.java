package com.akinzo.Walk2WealthUserService.service.register.hashPassword;


import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class HashPassword {

    public String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(4));
    }

    public boolean checkPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }



}

