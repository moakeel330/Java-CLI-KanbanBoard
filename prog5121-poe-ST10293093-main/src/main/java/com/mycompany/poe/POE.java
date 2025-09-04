/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.poe;

import javax.swing.*;
import java.util.ArrayList;

/**
 *
 * @author Mohamed Akeel Nazeer ST10293093
 */
public class POE {

    static Login login = new Login();
    static ArrayList<Task> tasksList = new ArrayList<>();

    public static void main(String[] args) {
        showMenu();
    }

    private static void showMenu() {
        // Display menu options until user chooses to exit
        int choice = 0;
        while (choice != 3) {
            try {
                // Allows for user input from the menu options
                choice = Integer.parseInt(JOptionPane.showInputDialog("Select an option:\n1. Register\n2. Login\n3. Exit"));
                switch (choice) {
                    case 1:
                        registerUser(); // Calls register method if user chooses 1
                        break;
                    case 2:
                        loginUser(); // Calls login method if the user chooses 2
                        break;
                    case 3:
                        // if user chooses option 3, displays exit message and terminates the program
                        JOptionPane.showMessageDialog(null, "Exiting.", "Exit", JOptionPane.WARNING_MESSAGE);
                        System.exit(0);
                        break;
                    default:
                        // if user enters an invalid option
                        JOptionPane.showMessageDialog(null, "Invalid option, please enter a number between 1 and 3");
                }
            } catch (NumberFormatException e) {
                // Handles if a user enters a non numeric value
                JOptionPane.showMessageDialog(null, "Invalid option, please enter a number.");
            }
        }
    }

    private static void registerUser() {
        // Implementing the user registration process

        String username = "";
        String password = "";
        String firstName = "";
        String lastName = "";

        JOptionPane.showMessageDialog(null, "======== Register ========", "Register", JOptionPane.INFORMATION_MESSAGE);

        // loop to ask for username until a valid name is given
        boolean validUsername = false;
        String usernameError;
        while (!validUsername) {
            username = JOptionPane.showInputDialog(null, "Enter your username:", "Register", JOptionPane.QUESTION_MESSAGE);
            // when username is blank error message will display otherwise it will verify the username by calling the Login class
            if (username.isBlank()) {
                JOptionPane.showMessageDialog(null, "Username cannot be blank", "Register", JOptionPane.ERROR_MESSAGE);
            } else if (login.checkUsername(username)) {
                JOptionPane.showMessageDialog(null, "Username successfully entered", "Register", JOptionPane.PLAIN_MESSAGE);
                validUsername = true;
            } else {
                usernameError = login.registerUser(username, "", "", "");
                JOptionPane.showMessageDialog(null, usernameError, "Register", JOptionPane.ERROR_MESSAGE);
            }
        }

        // loop to ask for password until a valid password is given
        boolean validPassword = false;
        String passwordError;
        // when password is blank error message will display otherwise it will verify the password by calling the Login class
        while (!validPassword) {
            password = JOptionPane.showInputDialog(null, "Enter your password:", "Register", JOptionPane.QUESTION_MESSAGE);
            if (password.isBlank()) {
                JOptionPane.showMessageDialog(null, "Password cannot be blank", "Register", JOptionPane.ERROR_MESSAGE);
            } else if (login.checkPasswordComplexity(password)) {
                JOptionPane.showMessageDialog(null, "Password successfully entered", "Register", JOptionPane.PLAIN_MESSAGE);
                validPassword = true;
            } else {
                passwordError = login.registerUser("", password, "", "");
                JOptionPane.showMessageDialog(null, passwordError, "Register", JOptionPane.ERROR_MESSAGE);
            }
        }

        // loop to ask for first name if the first name is left blank
        boolean blankFName = false;
        while (!blankFName) {
            firstName = JOptionPane.showInputDialog(null, "Enter your first name:", "Register", JOptionPane.QUESTION_MESSAGE);
            if (firstName.isBlank() || firstName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "First name cannot be blank", "Register", JOptionPane.PLAIN_MESSAGE);
            } else {
                blankFName = true;
            }
        }

        // loop to ask for last name if the first name is left blank
        boolean blankLName = false;
        while (!blankLName) {
            lastName = JOptionPane.showInputDialog(null, "Enter your last name", "Register", JOptionPane.QUESTION_MESSAGE);
            if (lastName.isBlank() || lastName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Last name cannot be blank", "Register", JOptionPane.PLAIN_MESSAGE);
            } else {
                blankLName = true;
            }
        }

        // Calls Login class to display registration success message 
        String registerMessage = login.registerUser(username, password, firstName, lastName);
        JOptionPane.showMessageDialog(null, registerMessage, "Register", JOptionPane.INFORMATION_MESSAGE);

        // Menu to confirm if user wants to carry on to login or return to main menu
        int choice = JOptionPane.showConfirmDialog(null, "Do you want to login?", "Login", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            loginUser();
        } else {
            showMenu();
        }
    }

    private static void loginUser() {
        // Implementing the user login process
        JOptionPane.showMessageDialog(null, "======== Login ========", "Login", JOptionPane.INFORMATION_MESSAGE);

        String username;
        String password;
        int attempts = 0;

        // Loop if the user enters details wrong 3 times then  can choose to go back to the main menu
        while (attempts < 3) {
            // Ask for username and password details to login.
            username = JOptionPane.showInputDialog(null, "Enter your username:", "Login", JOptionPane.QUESTION_MESSAGE);
            password = JOptionPane.showInputDialog(null, "Enter your password:", "Login", JOptionPane.QUESTION_MESSAGE);

            /*
            When user enters the correct details it will display a welcome message or if not then 
            an error message will display
             */
            boolean loggedIn = login.verifyLogin(username, password);
            if (loggedIn) {
                String loginMessage = login.returnLoginStatus(true);
                JOptionPane.showMessageDialog(null, loginMessage, "Login", JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(null, "Welcome to EasyKanban", "EasyKanban", JOptionPane.PLAIN_MESSAGE);
                showTaskMenu();
                return;
            } else {
                attempts++;
                String loginMessage = login.returnLoginStatus(false);
                JOptionPane.showMessageDialog(null, loginMessage, "Login", JOptionPane.PLAIN_MESSAGE);
            }
        }
        // options for if the user enters the details incorrect
        int choice = JOptionPane.showConfirmDialog(null, "You have failed to login 3 times, return to main menu?", "Login", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            showMenu();
        } else {
            JOptionPane.showMessageDialog(null, "Exiting.", "Login", JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }
    }

    // Start of part 2 Excluding the "Welcome to Kanban" message
    // Mehtod to display the task menu and allow user input
    private static void showTaskMenu() {
        int choice = 0;
        while (choice != 8) {
            try {
                // Display menu options and get user input
                choice = Integer.parseInt(JOptionPane.showInputDialog("Select an option:\n1. Add Task\n2. Show report\n3. Display done tasks\n4. Task with longest duration\n5. Search task by name\n6. Search tasks by developer\n7. Delete task by name\n8. Quit"));
                // Handle the user's choice
                switch (choice) {
                    case 1:
                        // Add a new task
                        Task.addTask();
                        break;
                    case 2:
                        // Show a report of tasks
                        Task.showReport();
                        break;
                    case 3:
                        // Display tasks marked as done
                        Task.displayDoneTasks();
                        break;
                    case 4:
                        // Display task with longest duration
                        Task.displayLongestTask();
                        break;
                    case 5:
                        // Search for a task by its name
                        Task.searchTaskByName();
                        break;
                    case 6:
                        // Search for a task by the developer
                        Task.searchTaskByDeveloper();
                        break;
                    case 7:
                        // Delete a task by its name
                        Task.deleteTaskByName();
                        break;
                    case 8:
                        // Quit the application
                        JOptionPane.showMessageDialog(null, "Quitting.", "Quit", JOptionPane.WARNING_MESSAGE);
                        System.exit(0);
                    default:
                        // if user enters an invalid option
                        JOptionPane.showMessageDialog(null, "Invalid option, please enter a number between 1 and 4");
                }
            } catch (NumberFormatException e) {
                // Handle non-integer inputs
                JOptionPane.showMessageDialog(null, "Invalid option, please enter a number.");
            }
        }
    }
}
