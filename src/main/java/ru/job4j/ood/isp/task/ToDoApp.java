package ru.job4j.ood.isp.task;

import java.util.Scanner;

public class ToDoApp {
    public static final String GREETINGS = "Hello, Guy! What are your plans for today?"
            + System.lineSeparator();
    public static final String CHOOSE = """
            Choose menu:
            1 -add item
            2 -print menu
            3 -exit
            """;
    public static final String WHAT_PARENT = "Enter parent";
    public static final String WHAT_CHILD = "Enter child";
    public static final String ADD_ITEM = "1";
    public static final String PRINT_MENU = "2";
    public static final String EXIT = "3";
    public static final String DEFAULT = "Wrong number!";

    public static void main(String[] args) {
        System.out.println(GREETINGS);
        Menu menu = new SimpleMenu();
        ToDoApp toDoApp = new ToDoApp();
        toDoApp.toDo(menu);
    }

    private void toDo(Menu menu) {
        MenuPrinter menuPrinter = new HardMenuPrinter();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(CHOOSE);
            String number = scanner.nextLine();
            switch (number) {
                case ADD_ITEM:
                    System.out.println(WHAT_PARENT);
                    String parent = scanner.nextLine();
                    System.out.println(WHAT_CHILD);
                    String child = scanner.nextLine();
                    menu.add(parent, child, ConstantValues.STUB_ACTION);
                    break;
                case PRINT_MENU:
                    menuPrinter.print(menu);
                    break;
                case EXIT:
                    return;
                default:
                    System.out.println(DEFAULT);
                    break;
            }
        }
    }
}