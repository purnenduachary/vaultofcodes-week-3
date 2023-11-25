import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList{
    private ArrayList<String> tasks;

    public ToDoList() {
        tasks = new ArrayList<>();
    }

    public void addTask(String task) {
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    public void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            String deletedTask = tasks.remove(index);
            System.out.println("Task deleted: " + deletedTask);
        } else {
            System.out.println("Invalid index. Task not deleted.");
        }
    }

    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in the to-do list.");
        } else {
            System.out.println("Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public void markTaskAsComplete(int index) {
        if (index >= 0 && index < tasks.size()) {
            String completedTask = tasks.get(index);
            tasks.set(index, "[Completed] " + completedTask);
            System.out.println("Task marked as complete: " + completedTask);
        } else {
            System.out.println("Invalid index. Task not marked as complete.");
        }
    }

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Task\n2. Delete Task\n3. Display Tasks\n4. Mark Task as Complete\n5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task to add: ");
                    String taskToAdd = scanner.nextLine();
                    toDoList.addTask(taskToAdd);
                    break;
                case 2:
                    System.out.print("Enter index of task to delete: ");
                    int indexToDelete = scanner.nextInt();
                    toDoList.deleteTask(indexToDelete - 1);
                    break;
                case 3:
                    toDoList.displayTasks();
                    break;
                case 4:
                    System.out.print("Enter index of task to mark as complete: ");
                    int indexToComplete = scanner.nextInt();
                    toDoList.markTaskAsComplete(indexToComplete - 1);
                    break;
                case 5:
                    System.out.println("Exiting the to-do list application. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}

