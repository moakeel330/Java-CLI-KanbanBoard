/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe;

/**
 *
 * @author moake
 */

/*
    A class for the login and registration functionality
*/
public class Login {

    //Variables to store user information
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    // Checks if username meets required format. Username to be checked
    public boolean checkUsername(String username) {
        return username.length() <= 5 && username.contains("_");
    }

    // Checks if password meets the requirements. Password to be checked
    public boolean checkPasswordComplexity(String password) {
        return password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*\\d.*") &&
                password.matches(".*[!@#$%^&*].*");
    }

     /**
     * Registers a new user with the provided information.
     *
     * @param username  The username of the user.
     * @param password  The password of the user.
     * @param firstName The first name of the user.
     * @param lastName  The last name of the user.
     * @return A message indicating the registration status.
     */
    
    public String registerUser(String username, String password, String firstName, String lastName) {
        if (!username.isEmpty() && !checkUsername(username)) {
                return "Username is not correctly formatted, please ensure that your username contains an underscore and is no " +
                        "more than 5 characters in length";
        }

        if (!password.isEmpty() && !checkPasswordComplexity(password)) {
                return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, " +
                        "a capital letter, a number, and a special character";
        }

        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        return "User registered successfully";
    }

    // checks if the provided username and password match the stored information to confirm login
    public boolean verifyLogin(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    // Return a login status message based on whether the user is logged in or not
    public String returnLoginStatus(boolean loggedIn) {
        if (loggedIn) {
            return "Welcome " + firstName + " " + lastName + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}
