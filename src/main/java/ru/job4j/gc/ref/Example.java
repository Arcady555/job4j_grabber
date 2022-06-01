package ru.job4j.gc.ref;

import ru.job4j.gc.User;

import java.lang.ref.SoftReference;

public class Example {
    public static void main(String[] args) {

        User[] array = new User[100];

        SoftReference[] softArray = new SoftReference[100];

        for (int i = 0; i < 100; i++) {
            array[i] = new User(i);
            softArray[i] = new SoftReference<>(array[i]);
        }

        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                array[i] = null;
            }
        }

        for (User user : array) {
            System.out.println(user);
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = (User) softArray[i].get();
            }
        }

        System.out.println("============================================================");

        for (User user : array) {
            System.out.println(user);
        }
    }
}