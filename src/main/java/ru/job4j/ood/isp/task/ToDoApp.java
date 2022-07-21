package ru.job4j.ood.isp.task;

import java.util.Scanner;

public class ToDoApp {
    public static final String GREETINGS = "Hello, Guy! What are your plans for today?\n";
    public static final String CHOOSE = System.lineSeparator()
            + "Choose menu:\n1- add item\n2-print menu\n3-exit";
    public static final String WHAT_PARENT = "Enter parent";
    public static final String WHAT_CHILD = "Enter child";
    public static final String STOP_WORD = "no";

    public static void main(String[] args) {
        System.out.println(GREETINGS);
        Menu menu = new SimpleMenu();
        ToDoApp toDoApp = new ToDoApp();
        toDoApp.toDo(menu);
    }

    private void toDo(Menu menu) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(CHOOSE);
            String number = scanner.nextLine();
            switch (number) {
                case "1":
                    System.out.println(WHAT_PARENT);
                    String parent = scanner.nextLine();
                    System.out.println(WHAT_CHILD);
                    String child = scanner.nextLine();
                    menu.add(parent, child, ConstantValues.STUB_ACTION);
                    break;
                case "2":
                    MenuPrinter menuPrinter = new HardMenuPrinter();
                    menuPrinter.print(menu);
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Wrong number!");
                    break;
            }
        }
    }
}