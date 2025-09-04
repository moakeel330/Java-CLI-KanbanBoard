/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author moake
 */
public class LoginIT {
    
    public LoginIT() {
    }

    /**
     * Test of checkUsername method, of class Login.
     */
    @Test
    public void testCheckUsername() {
        System.out.println("checkUsername");
        String username = "kyle!!!!!!!";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.checkUsername(username);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkPasswordComplexity method, of class Login.
     */
    @Test
    public void testCheckPasswordComplexity() {
        System.out.println("checkPasswordComplexity");
        String password = "Ch&&sec@ke99!";
        Login instance = new Login();
        boolean expResult = true;
        boolean result = instance.checkPasswordComplexity(password);
        assertEquals(expResult, result);
    }

    /**
     * Test of registerUser method, of class Login.
     */
    @Test
    public void testRegisterUser() {
        System.out.println("registerUser");
        String username = "kyl_1";
        String password = "Ch&&sec@ke99!";
        String firstName = "Kyle";
        String lastName = "Kyle";
        Login instance = new Login();
        String expResult = "";
        String result = instance.registerUser(username, password, firstName, lastName);
        assertEquals(expResult, result);
    }

    /**
     * Test of verifyLogin method, of class Login.
     */
    @Test
    public void testVerifyLogin() {
        System.out.println("verifyLogin");
        String username = "kyl_1";
        String password = "Ch&&sec@ke99!";
        Login instance = new Login();
        boolean expResult = true;
        boolean result = instance.verifyLogin(username, password);
        assertEquals(expResult, result);
    }

    /**
     * Test of returnLoginStatus method, of class Login.
     */
    @Test
    public void testReturnLoginStatus() {
        System.out.println("returnLoginStatus");
        boolean loggedIn = true;
        Login instance = new Login();
        String expResult = "";
        String result = instance.returnLoginStatus(loggedIn);
        assertEquals(expResult, result);
    }
    
}
