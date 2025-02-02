package com.akinzo.Walk2WealthUserService.service.email;
import org.springframework.stereotype.Service;

import java.util.regex.*;
@Service
public class EmailValidator {

    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        public static boolean validateEmail(String email) {
            Pattern pattern = Pattern.compile(EMAIL_REGEX);
            Matcher matcher = pattern.matcher(email);
            return matcher.matches();
        }
}
