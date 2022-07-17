package ru.job4j.ood.isp.task;

import java.util.Scanner;

public class ToDoApp {
    public static void main(String[] args) {
        System.out.println("Hello, Guy! What are your plans for today?");
        Menu menu = new SimpleMenu();
        MenuPrinter menuPrinter = new HardMenuPrinter();
        ToDoApp toDoApp = new ToDoApp();
        toDoApp.toDo(menu);
        menuPrinter.print(menu);
    }

    private void toDo(Menu menu) {
        final ActionDelegate stubAction = System.out::println;
        int counter = 1;
        while (true) {
            System.out.println("Enter task number" + counter);
            Scanner scanner1 = new Scanner(System.in);
            String task1 = scanner1.nextLine();
            if (task1.equals("no")) {
                return;
            }
            menu.add(Menu.ROOT, task1, stubAction);
            counter++;
            while (true) {
                System.out.println("What will be in the task?");
                Scanner scanner11 = new Scanner(System.in);
                String task11 = scanner11.nextLine();
                if (task11.equals("nothing")) {
                    break;
                }
                menu.add(task1, task11, stubAction);
                while (true) {
                    System.out.println("What will be in the SUBtask?");
                    Scanner scanner111 = new Scanner(System.in);
                    String task111 = scanner111.nextLine();
                    if (task111.equals("nothing")) {
                        break;
                    }
                    menu.add(task11, task111, stubAction);
                }
            }
        }
    }
}
