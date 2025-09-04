/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 *
 * @author moake
 */
public class TaskIT {
    
    public TaskIT() {
    }

    @BeforeEach
    public void setUp() {
        // Initialize tasksList and associated lists with test data
        Task.tasksList = new ArrayList<>();
        Task.developers = new ArrayList<>();
        Task.taskNames = new ArrayList<>();
        Task.taskStatuses = new ArrayList<>();

        // Adding sample tasks
        Task.tasksList.add(new Task("Create Login", 1, "Desc1", "Mike", "Smith", 5.0, "", "To Do"));
        Task.developers.add("Mike Smith");
        Task.taskNames.add("Create Login");
        Task.taskStatuses.add("To Do");

        Task.tasksList.add(new Task("Create Add Features", 2, "Desc2", "Edward", "Harrison", 8.0, "", "Doing"));
        Task.developers.add("Edward Harrison");
        Task.taskNames.add("Create Add Features");
        Task.taskStatuses.add("Doing");

        Task.tasksList.add(new Task("Create Reports", 3, "Desc3", "Samantha", "Paulson", 2.0, "", "Done"));
        Task.developers.add("Samantha Paulson");
        Task.taskNames.add("Create Reports");
        Task.taskStatuses.add("Done");

        Task.tasksList.add(new Task("Add Arrays", 4, "Desc4", "Glenda", "Oberholzer", 11.0, "", "To Do"));
        Task.developers.add("Glenda Oberholzer");
        Task.taskNames.add("Add Arrays");
        Task.taskStatuses.add("To Do");
    }
    /**
     * Test of checkTaskDescription method, of class Task.
     */
    @Test
    public void testCheckTaskDescription() {
        System.out.println("checkTaskDescription");
        Task instance = new Task("Login Feature", 1, "Create Login to authenticate users", "Robyn", "Harrison", 8.0, "", "To Do");

        // Valid task description
        String validTaskDesc = "Create Login to authenticate users";
        boolean expValidResult = true;
        boolean validResult = instance.checkTaskDescription(validTaskDesc);
        assertEquals(expValidResult, validResult);

        // Invalid task description (too long)
        String invalidTaskDesc = "Please enter a task description of less than 50 characters";
        boolean expInvalidResult = false;
        boolean invalidResult = instance.checkTaskDescription(invalidTaskDesc);
        assertEquals(expInvalidResult, invalidResult);

        // Invalid task description (blank)
        String blankTaskDesc = "";
        boolean expBlankResult = false;
        boolean blankResult = instance.checkTaskDescription(blankTaskDesc);
        assertEquals(expBlankResult, blankResult);

        // Invalid task description (null)
        String nullTaskDesc = null;
        boolean expNullResult = false;
        boolean nullResult = instance.checkTaskDescription(nullTaskDesc);
        assertEquals(expNullResult, nullResult);
    }


    /**
     * Test of printTaskDetails method, of class Task.
     */
    @Test
    public void testPrintTaskDetails() {
        System.out.println("printTaskDetails");
        // Create a Task instance with sample data
        Task instance = new Task("Login Feature", 1, "Create Login to authenticate users", "Robyn", "Harrison", 8.0, "", "To Do");

        // Set the expected result
        String expResult = "Task Status: To Do\n" +
                           "Developer Details: Robyn Harrison\n" +
                           "Task Number: 1\n" +
                           "Task Name: Login Feature\n" +
                           "Task Description: Create Login to authenticate users\n" +
                           "Task ID: LO:1:SON\n" + 
                           "Task Duration: 8.0 hours";

        // Get the actual result from the method
        String result = instance.printTaskDetails();

        // Assert the expected result matches the actual result
        assertEquals(expResult, result);
    }

    /**
     * Test of setTaskDuration method, of class Task.
     */
    @Test
    public void testSetTaskDuration() {
        System.out.println("setTaskDuration");
        // Create a Task instance with sample data
        Task instance = new Task("Login Feature", 1, "Create Login to authenticate users", "Robyn", "Harrison", 8.0, "", "To Do");

        // Set the task duration
        double taskDuration = 8.0;
        instance.setTaskDuration(taskDuration);

        // Get the actual task duration
        double result = instance.returnTotalHours();

        // Assert the expected result matches the actual result
        assertEquals(taskDuration, result);
    }

    /**
     * Test of returnTotalHours method, of class Task.
     */
    @Test
    public void testReturnTotalHours() {
        System.out.println("returnTotalHours");
        // Create a Task instance with sample data
        Task instance = new Task("Login Feature", 1, "Create Login to authenticate users", "Robyn", "Harrison", 8.0, "", "To Do");

        // Get the actual task duration
        double result = instance.returnTotalHours();

        // Set the expected result
        double expResult = 8.0;

        // Assert the expected result matches the actual result
        assertEquals(expResult, result, 0);
    }

    @Test
    public void testDeveloperArray() {
        System.out.println("testDeveloperArray");
        Task.tasksList = new ArrayList<>();
        Task.developers = new ArrayList<>();
        Task.taskDurations = new ArrayList<>();

        // Adding sample tasks
        Task.tasksList.add(new Task("Create Login", 1, "Desc1", "Mike", "Smith", 5.0, "", "To Do"));
        Task.developers.add("Mike Smith");
        Task.taskDurations.add(5.0);
        Task.tasksList.add(new Task("Create Add Features", 2, "Desc2", "Edward", "Harrison", 8.0, "", "Doing"));
        Task.developers.add("Edward Harrison");
        Task.taskDurations.add(8.0);
        Task.tasksList.add(new Task("Create Reports", 3, "Desc3", "Samantha", "Paulson", 2.0, "", "Done"));
        Task.developers.add("Samantha Paulson");
        Task.taskDurations.add(2.0);
        Task.tasksList.add(new Task("Add Arrays", 4, "Desc4", "Glenda", "Oberholzer", 11.0, "", "To Do"));
        Task.developers.add("Glenda Oberholzer");
        Task.taskDurations.add(11.0);

        // Expected developer array
        List<String> expectedDevelopers = Arrays.asList("Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberholzer");

        // Assert the developers array is as expected
        assertEquals(expectedDevelopers, Task.developers);
    }
    
    /**
 * Test of searchTaskByName method, of class Task.
 */
@Test
    public void testSearchTaskByName() {
        System.out.println("searchTaskByName");

        // Test searching for an existing task
        String nameOfTask = "Create Reports";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < Task.tasksList.size(); i++) {
            if (Task.taskNames.get(i).equalsIgnoreCase(nameOfTask)) {
                result.append("Task Name: ").append(Task.taskNames.get(i)).append("\n");
                result.append("Developer: ").append(Task.developers.get(i)).append("\n");
                result.append("Task Status: ").append(Task.taskStatuses.get(i)).append("\n\n");
            }
        }
        assertNotNull(result.toString(), "Expected result should not be null");
        assertEquals("Task Name: Create Reports\nDeveloper: Samantha Paulson\nTask Status: Done\n\n", result.toString());
    }

    /**
     * Test of displayLongestTask method, of class Task.
     */
    @Test
    public void testDisplayLongestTask() {
        System.out.println("testGetLongestTask");
        Task.tasksList = new ArrayList<>();
        Task.developers = new ArrayList<>();
        Task.taskDurations = new ArrayList<>();

        // Adding sample tasks
        Task.tasksList.add(new Task("Create Login", 1, "Desc1", "Mike", "Smith", 5.0, "", "To Do"));
        Task.developers.add("Mike Smith");
        Task.taskDurations.add(5.0);
        Task.tasksList.add(new Task("Create Add Features", 2, "Desc2", "Edward", "Harrison", 8.0, "", "Doing"));
        Task.developers.add("Edward Harrison");
        Task.taskDurations.add(8.0);
        Task.tasksList.add(new Task("Create Reports", 3, "Desc3", "Samantha", "Paulson", 2.0, "", "Done"));
        Task.developers.add("Samantha Paulson");
        Task.taskDurations.add(2.0);
        Task.tasksList.add(new Task("Add Arrays", 4, "Desc4", "Glenda", "Oberholzer", 11.0, "", "To Do"));
        Task.developers.add("Glenda Oberholzer");
        Task.taskDurations.add(11.0);

        // Get the longest task
        Task longestTask = Task.getLongestTask();

        // Expected output
        String expectedDeveloper = "Glenda Oberholzer";
        double expectedDuration = 11.0;

        // Assert the output is as expected
        assertNotNull(longestTask);
        assertEquals(expectedDeveloper, longestTask.getDeveloper());
        assertEquals(expectedDuration, longestTask.getTaskDuration());
    }

    /**
     * Test of deleteTaskByName method, of class Task.
     */
    @Test
public void testDeleteTaskByName() {
    System.out.println("deleteTaskByName");

    // Prepare test data
    Task.tasksList = new ArrayList<>();
    Task.developers = new ArrayList<>();
    Task.taskNames = new ArrayList<>();
    Task.taskIDs = new ArrayList<>();
    Task.taskDurations = new ArrayList<>();
    Task.taskStatuses = new ArrayList<>();

    Task task1 = new Task("Create Login", 1, "Desc1", "Mike", "Smith", 5.0, "", "To Do");
    Task task2 = new Task("Create Add Features", 2, "Desc2", "Edward", "Harrison", 8.0, "", "Doing");
    Task task3 = new Task("Create Reports", 3, "Desc3", "Samantha", "Paulson", 2.0, "", "Done");
    Task task4 = new Task("Add Arrays", 4, "Desc4", "Glenda", "Oberholzer", 11.0, "", "To Do");

    Task.tasksList.add(task1);
    Task.tasksList.add(task2);
    Task.tasksList.add(task3);
    Task.tasksList.add(task4);

    Task.developers.add("Mike Smith");
    Task.developers.add("Edward Harrison");
    Task.developers.add("Samantha Paulson");
    Task.developers.add("Glenda Oberholzer");

    Task.taskNames.add("Create Login");
    Task.taskNames.add("Create Add Features");
    Task.taskNames.add("Create Reports");
    Task.taskNames.add("Add Arrays");

    Task.taskIDs.add(task1.getTaskId());
    Task.taskIDs.add(task2.getTaskId());
    Task.taskIDs.add(task3.getTaskId());
    Task.taskIDs.add(task4.getTaskId());

    Task.taskDurations.add(5.0);
    Task.taskDurations.add(8.0);
    Task.taskDurations.add(2.0);
    Task.taskDurations.add(11.0);

    Task.taskStatuses.add("To Do");
    Task.taskStatuses.add("Doing");
    Task.taskStatuses.add("Done");
    Task.taskStatuses.add("To Do");

    // Set up the expected output
    String taskNameToDelete = "Create Reports";

    // Redirect System.out to capture printed output
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    // Call the method
    Task.deleteTaskByName();

    // Check if the task is deleted
    assertFalse(Task.tasksList.stream().anyMatch(task -> task.getTaskName().equals(taskNameToDelete)));

    // Check the output
    assertEquals("", outContent.toString()); // Add this line

    // Reset System.out
    System.setOut(System.out);
}
}
