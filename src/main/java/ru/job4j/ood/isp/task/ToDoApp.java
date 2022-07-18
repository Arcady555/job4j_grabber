package ru.job4j.ood.isp.task;

import java.util.Scanner;

public class ToDoApp {
    public static void main(String[] args) {
        System.out.println(ConstantValues.GREETINGS);
        Menu menu = new SimpleMenu();
        MenuPrinter menuPrinter = new HardMenuPrinter();
        ToDoApp toDoApp = new ToDoApp();
        toDoApp.toDo(menu);
        menuPrinter.print(menu);
    }

    private void toDo(Menu menu) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(ConstantValues.WHAT_PARENT);
            String parent = scanner.nextLine();
            if (parent.equals(ConstantValues.STOP_WORD)) {
                break;
            }
            System.out.println(ConstantValues.WHAT_CHILD);
            String child = scanner.nextLine();
            menu.add(parent, child, ConstantValues.STUB_ACTION);
        }
    }
}
