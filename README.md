[README.md](https://github.com/user-attachments/files/22954509/README.md)

# Java GUI Kanban Board

A GUI Kanban-style board application implemented in Java.
This tool allows users to manage tasks (cards) across different stages (To Do, In Progress, Done).


## Features

- Add new tasks (cards) with title, description, priority, etc.
- Move tasks between columns / stages (To Do → In Progress → Done)
- List tasks by their status / column
- Delete tasks


## How it works

The app runs with basic swing GUI and accepts input (e.g. add, list, move, delete).
Internally, tasks are stored in data structures (lists / maps) representing columns.
The program validates user input, shows prompts, and prints structured output to guide the user.
Allows user to login and validates login and sign up information.
## Usage/Examples
Prerequisites
Java Development Kit (JDK) installed (Java 8 or above)
A terminal / command prompt
(Optional) Build tool like Maven or Gradle if used

Installation & Setup
Clone the repository:
```
git clone https://github.com/moakeel330/Java-CLI-KanbanBoard.git
cd Java-CLI-KanbanBoard/prog5121-poe-ST10293093-main
```

Running the Program
If there's a main class (e.g. Main.java), you can run it via:
```
javac -d out $(find . -name "*.java")
java -cp out path.to.MainClass
```



## Enhancements

- Add search or filter by keyword, priority, or status
- Add due dates or deadlines for tasks
- Implement persistence using JSON / plain text / serialization
- Add undo / redo feature
- Support multiple boards or user accounts
- Add command line arguments to batch operations
- Improve the UX: colored console output, menus, input validation
- Build a GUI or web version using JavaFX or Spring Boot
