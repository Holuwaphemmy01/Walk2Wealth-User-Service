package com.akinzo.Walk2WealthUserService.service.password;

import java.util.regex.Pattern;

public class PasswordValidator {

    // Define password rules using regex
    private static final String PASSWORD_REGEX =
            "^(?=.*[0-9])" +       // At least one digit
                    "(?=.*[a-z])" +        // At least one lowercase letter
                    "(?=.*[A-Z])" +        // At least one uppercase letter
                    "(?=.*[!@#$%^&*()])" + // At least one special character
                    "(?=\\S+$)" +          // No whitespace allowed
                    ".{8,}$";              // Minimum length of 8 characters

    // Pre-compile the regex pattern for better performance
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);

    /**
     * Validates a password based on the defined rules.
     *
     * @param password The password to validate.
     * @return true if the password is valid, false otherwise.
     */
    public static boolean validatePassword(String password) {
        if (password == null) {
            return false; // Null passwords are invalid
        }
        return PASSWORD_PATTERN.matcher(password).matches();
    }
}
