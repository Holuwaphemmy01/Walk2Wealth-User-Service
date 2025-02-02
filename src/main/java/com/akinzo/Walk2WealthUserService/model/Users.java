package com.akinzo.Walk2WealthUserService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Users {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @Id
    private String id;
}
