package com.akinzo.Walk2WealthUserService.service.register;

import com.akinzo.Walk2WealthUserService.dtos.request.UserRegisterRequest;
import com.akinzo.Walk2WealthUserService.repository.UsersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRegisterServiceImplTest {

    @Autowired
    private UserRegisterServiceImpl userRegisterService;
    @Autowired
    private UsersRepository usersRepository;

    @BeforeEach
    void setUp() {
        usersRepository.deleteAll();
    }

    @Test
    void testToThrowExceptionWhenFirstNameIsBlank() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setFirstName("");
        assertThrows(IllegalArgumentException.class, () -> userRegisterService.registerUser(userRegisterRequest));
    }

    @Test
    void testToThrowExceptionWhenLastNameIsBlank() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setFirstName("first name");
        userRegisterRequest.setLastName("");
        assertThrows(IllegalArgumentException.class, () -> userRegisterService.registerUser(userRegisterRequest));
    }

    @Test
    void testToThrowExceptionWhenEmailIsBlank() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setFirstName("first name");
        userRegisterRequest.setLastName("last name");
        userRegisterRequest.setEmail("");
        assertThrows(IllegalArgumentException.class, () -> userRegisterService.registerUser(userRegisterRequest));
    }

    @Test
    void testToThrowExceptionWhenEmailIsInvalid() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setFirstName("first name");
        userRegisterRequest.setLastName("last name");
        userRegisterRequest.setEmail("invalid");
        assertThrows(IllegalArgumentException.class, () -> userRegisterService.registerUser(userRegisterRequest));
    }

    @Test
    void testToThrowExceptionWhenPasswordIsEmptyOrBlank() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setFirstName("first name");
        userRegisterRequest.setLastName("last name");
        userRegisterRequest.setEmail("correct@gmail.com");
        userRegisterRequest.setPassword("");
        assertThrows(IllegalArgumentException.class, () -> userRegisterService.registerUser(userRegisterRequest));
    }

    @Test
    void testToThrowExceptionWhenPasswordLessThan8Characters() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setFirstName("first name");
        userRegisterRequest.setLastName("last name");
        userRegisterRequest.setEmail("correct@gmail.com");
        userRegisterRequest.setPassword("Oluwaf");
        assertThrows(IllegalArgumentException.class, () -> userRegisterService.registerUser(userRegisterRequest));
    }

    @Test
    void testToThrowExceptionWhenPasswordDidNotIncludeUppercase() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setFirstName("first name");
        userRegisterRequest.setLastName("last name");
        userRegisterRequest.setEmail("correct@gmail.com");
        userRegisterRequest.setPassword("oluwafemi");
        assertThrows(IllegalArgumentException.class, () -> userRegisterService.registerUser(userRegisterRequest));
    }

    @Test
    void testToThrowExceptionWhenPasswordDidNotIncludeLowercase() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setFirstName("first name");
        userRegisterRequest.setLastName("last name");
        userRegisterRequest.setEmail("correct@gmail.com");
        userRegisterRequest.setPassword("OLUWAFEMI");
        assertThrows(IllegalArgumentException.class, () -> userRegisterService.registerUser(userRegisterRequest));
    }

    @Test
    void testToThrowExceptionWhenPasswordDidNotIncludeSpecialCharacters() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setFirstName("first name");
        userRegisterRequest.setLastName("last name");
        userRegisterRequest.setEmail("correct@gmail.com");
        userRegisterRequest.setPassword("Oluwafemi");
        assertThrows(IllegalArgumentException.class, () -> userRegisterService.registerUser(userRegisterRequest));
    }

    @Test
    void testToThrowExceptionWhenPasswordDidNotIncludeNumbers() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setFirstName("first name");
        userRegisterRequest.setLastName("last name");
        userRegisterRequest.setEmail("correct@gmail.com");
        userRegisterRequest.setPassword("Oluwafemi..");
        assertThrows(IllegalArgumentException.class, () -> userRegisterService.registerUser(userRegisterRequest));
    }

    @Test
    void testToRegisterUserSuccessfullyAndIdIsGeneratedAndIdIsNotEmpty() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setFirstName("first name");
        userRegisterRequest.setLastName("last name");
        userRegisterRequest.setEmail("correct@gmail.com");
        userRegisterRequest.setPassword("Victor2002@..,");
        userRegisterRequest.setUsername("adewale");
        String users = userRegisterService.registerUser(userRegisterRequest);
        System.out.println(users);
        assertNotNull(users);
    }

    @Test
    void testToThrowExceptionWhenARegisteredEmailIsBeingUsedAgain() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setFirstName("first");
        userRegisterRequest.setLastName("last ");
        userRegisterRequest.setEmail("correctMail@gmail.com");
        userRegisterRequest.setPassword("Victor2002@..,");
        userRegisterRequest.setUsername("adewale");
        String users = userRegisterService.registerUser(userRegisterRequest);
        assertNotNull(users);

        UserRegisterRequest userRegisterRequest2 = new UserRegisterRequest();
        userRegisterRequest2.setFirstName("first name");
        userRegisterRequest2.setLastName("last name");
        userRegisterRequest2.setEmail("correctMail@gmail.com");
        userRegisterRequest2.setPassword("Victor2002@..,");
        userRegisterRequest2.setUsername("adewale");
        assertThrows(IllegalArgumentException.class, () -> userRegisterService.registerUser(userRegisterRequest2));

    }



    @Test
    void testToThrowExceptionWhenARegisteredUsernamesBeingUsedAgain() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setFirstName("first");
        userRegisterRequest.setLastName("last ");
        userRegisterRequest.setEmail("correct@gmail.com");
        userRegisterRequest.setPassword("Victor2002@..,");
        userRegisterRequest.setUsername("adewale");
        String users = userRegisterService.registerUser(userRegisterRequest);
        assertNotNull(users);

        UserRegisterRequest userRegisterRequest2 = new UserRegisterRequest();
        userRegisterRequest2.setFirstName("first name");
        userRegisterRequest2.setLastName("last name");
        userRegisterRequest2.setEmail("correctMail@gmail.com");
        userRegisterRequest2.setPassword("Victor2002@..,");
        userRegisterRequest2.setUsername("adewale");
        assertThrows(IllegalArgumentException.class, () -> userRegisterService.registerUser(userRegisterRequest2));
        assertEquals(usersRepository.count(), 1);

    }



}


