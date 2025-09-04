/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Task class shows a task in the system
 * Contains details about the tasks
 * 
 *
 * @author moake
 */
public class Task {
    static ArrayList<Task> tasksList = new ArrayList<>();
    static ArrayList<String> developers = new ArrayList<>();
    static ArrayList<String> taskNames = new ArrayList<>();
    static ArrayList<String> taskIDs = new ArrayList<>();
    static ArrayList<Double> taskDurations = new ArrayList<>();
    static ArrayList<String> taskStatuses = new ArrayList<>();
    // Store all task details
    private String taskName;
    private int taskNumber;
    private String taskDesc;
    private String devFName;
    private String devLName;
    private double taskDuration;
    private String taskId;
    private String taskStatus;

    /**
     * Constructor to initialize a new Task object.
     * 
     * @param taskName the name of the task
     * @param taskNumber the unique number of the task
     * @param taskDesc a brief description of the task
     * @param devFName the first name of the developer assigned to the task
     * @param devLName the last name of the developer assigned to the task
     * @param taskDuration the estimated duration of the task in hours
     * @param taskId a unique identifier for the task (will be generated)
     * @param taskStatus the current status of the task (e.g., To Do, Done, Doing)
     */
    
    public Task(String taskName, int taskNumber, String taskDesc, String devFName, String devLName, double taskDuration, String taskId, String taskStatus) {
        this.taskName = taskName;
        this.taskNumber = taskNumber;
        this.taskDesc = taskDesc;
        this.devFName = devFName;
        this.devLName = devLName;
        this.taskDuration = taskDuration;
        this.taskId = generateTaskID();
        this.taskStatus = taskStatus;
    }
    
    // Check if task description is valid
    public static boolean checkTaskDescription(String taskDesc) {
        return taskDesc != null && !taskDesc.isBlank() && taskDesc.length() <= 50;
    }
    
    // Check if task Name is valid
    public boolean isValidTaskName(String taskName) {
        return taskName != null && !taskName.isBlank();
    }
    // Check if first name is valid
    public boolean isValidFName(String devFname) {
        return devFname != null && !devFname.isBlank();
    }
    // Check if last name is valid
    public boolean isValidLName(String devLname) {
        return devLname != null && !devLname.isBlank();
    }

    // Generates unique ID based on the task name and developers last name
    private String generateTaskID() {
        if (!taskName.isEmpty()) {
            String taskLetters = taskName.substring(0, 2).toUpperCase();
            String devLetters = devLName.substring(devLName.length() - 3).toUpperCase();
            return taskLetters + ":" + taskNumber + ":" + devLetters;
        } else {
            return "";
        }
    }

    // Returns string containing the details of the task
    public String printTaskDetails() {
        return "Task Status: " + taskStatus +
                "\nDeveloper Details: " + devFName + " " + devLName +
                "\nTask Number: " + taskNumber +
                "\nTask Name: " + taskName +
                "\nTask Description: " + taskDesc +
                "\nTask ID: " + taskId +
                "\nTask Duration: " + taskDuration + " hours";
    }

    // Sets the duration of the task
    public void setTaskDuration(double taskDuration) {
        this.taskDuration = taskDuration;
    }
    
    // Get the task duration
     public double getTaskDuration() {
        return taskDuration;
    }
    // Get the task name
     public String getTaskName() {
        return this.taskName;
    }

    // Returns the total duration of all tasks
    public double returnTotalHours() {
        return taskDuration;
    }
    // Get the task ID
     public String getTaskId() {
        return taskId;
    }
     // Get the task status
    public String getTaskStatus() {
        return taskStatus;
    }

    // Add Task
    public static void addTask() {
        Task newTask;
        double totalDuration = 0;
        int taskCounter = 0;
        
        // Prompt user for the number of tasks to input
        int taskNum = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasks you want to input:"));

        // Loop to get input for the amount of tasks given
        for (int i = 0; i < taskNum; i++) {
            // Get task details from user
            String taskName = JOptionPane.showInputDialog("Enter the task name:");
            int taskNumber = taskCounter++;

            // Validate task description
            String taskDesc = "";
            boolean validDesc = false;
            while (!validDesc) {
                taskDesc = JOptionPane.showInputDialog(null, "Enter the task description:");
                if (taskDesc.isBlank()) {
                    JOptionPane.showMessageDialog(null, "Task description cannot be blank", "Add Tasks", JOptionPane.ERROR_MESSAGE);
                } else if ((checkTaskDescription(taskDesc))) {
                    JOptionPane.showMessageDialog(null, "Task successfully entered", "Add Tasks", JOptionPane.PLAIN_MESSAGE);
                    validDesc = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid task description, please enter a valid description");
                }
            }

            String devFName = JOptionPane.showInputDialog("Enter the first name of the developer assigned to the task:");
            String devLName = JOptionPane.showInputDialog("Enter the last name of the developer assigned to the task:");
            double taskDuration = Double.parseDouble(JOptionPane.showInputDialog("Enter the duration of the task in hours:"));

            // Prompt for task status
            String[] statusOptions = {"To Do", "Done", "Doing"};
            String taskStatus = (String) JOptionPane.showInputDialog(null, "Choose the status of the task", "Task Status", JOptionPane.QUESTION_MESSAGE, null, statusOptions, statusOptions[0]);

            // Create new Task and add to list
            newTask = new Task(taskName, taskNumber, taskDesc, devFName, devLName, taskDuration, "", taskStatus);
            tasksList.add(newTask);

            // Update total duration
            newTask.setTaskDuration(taskDuration);
            totalDuration += newTask.returnTotalHours();
            // Display task details
            JOptionPane.showMessageDialog(null, newTask.printTaskDetails());

            // add task details to the needed lists
            developers.add(devFName + " " + devLName);
            taskNames.add(taskName);
            taskIDs.add(newTask.getTaskId());
            taskDurations.add(taskDuration);
            taskStatuses.add(taskStatus);
        }
        // Display total duration of all tasks
        JOptionPane.showMessageDialog(null, "Total duration: " + totalDuration);
    }

    // Show report of all tasks
    public static void showReport() {
        if (tasksList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tasks available.");
            return;
        }

        StringBuilder taskInfo = new StringBuilder();
        for (Task task : tasksList) {
            taskInfo.append(task.printTaskDetails()).append("\n\n");
        }
        JOptionPane.showMessageDialog(null, taskInfo.toString());
    }

    // Display all tasks with the status done
    public static void displayDoneTasks() {
        StringBuilder doneTasks = new StringBuilder();
        for (int i = 0; i < tasksList.size(); i++) {
            if (tasksList.get(i).getTaskStatus().equals("Done")) {
                doneTasks.append("Developer: ").append(developers.get(i)).append("\n");
                doneTasks.append("Task Name: ").append(taskNames.get(i)).append("\n");
                doneTasks.append("Task Duration: ").append(taskDurations.get(i)).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, !doneTasks.isEmpty() ? doneTasks.toString() : "No tasks with status 'Done'.");
    }

    // Get the task with the longest duration
    public static Task getLongestTask() {
    Task longestTask = null;
    double maxDuration = 0;

    for (Task task : tasksList) {
        if (task.taskDuration > maxDuration) {
            maxDuration = task.taskDuration;
            longestTask = task;
        }
    }

    return longestTask;
}
    // Display the task with the longest duration
    public static void displayLongestTask() {
        Task longestTask = getLongestTask();

        if (longestTask != null) {
            String message = "Developer: " + longestTask.getDeveloper() + "\nTask Duration: " + longestTask.getTaskDuration() + " hours";
            JOptionPane.showMessageDialog(null, message);
        }
    }

    // Get developers full name
    public String getDeveloper() {
    return devFName + " " + devLName;
}

    // Search for task by name
    public static void searchTaskByName() {
        String nameOfTask = JOptionPane.showInputDialog("Enter the task name to search:");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < tasksList.size(); i++) {
            if (taskNames.get(i).equalsIgnoreCase(nameOfTask)) {
                result.append("Task Name: ").append(taskNames.get(i)).append("\n");
                result.append("Developer: ").append(developers.get(i)).append("\n");
                result.append("Task Status: ").append(taskStatuses.get(i)).append("\n\n");
            }
        }
        JOptionPane.showMessageDialog(null, !result.isEmpty() ? result.toString() : "No task found with the name '" + nameOfTask + "'.");
    }

    // Search for task by developer name
    public static void searchTaskByDeveloper() {
        String devName = JOptionPane.showInputDialog("Enter the developer name to search:");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < tasksList.size(); i++) {
            if (developers.get(i).equalsIgnoreCase(devName)) {
                result.append("Task Name: ").append(taskNames.get(i)).append("\n");
                result.append("Task Status: ").append(taskStatuses.get(i)).append("\n\n");
            }
        }
        JOptionPane.showMessageDialog(null, !result.isEmpty() ? result.toString() : "No tasks found for developer '" + devName + "'.");
    }

    // Delete task by task name
    public static void deleteTaskByName() {
        String taskName = JOptionPane.showInputDialog("Enter the task name to delete:");
        for (int i = 0; i < tasksList.size(); i++) {
            if (taskNames.get(i).equalsIgnoreCase(taskName)) {
                tasksList.remove(i);
                developers.remove(i);
                taskNames.remove(i);
                taskIDs.remove(i);
                taskDurations.remove(i);
                taskStatuses.remove(i);
                JOptionPane.showMessageDialog(null, "Task '" + taskName + "' deleted successfully.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "No task found with the name '" + taskName + "'.");
    }
}
