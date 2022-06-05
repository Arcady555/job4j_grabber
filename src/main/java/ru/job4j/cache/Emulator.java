package ru.job4j.cache;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Emulator {
    public static void main(String[] args) throws IOException {
        while (true) {
            System.out.println("Откуда будет файл?\n"
                    + "1 - Из системы.\n"
                    + "2 - Из базы данных.\n"
                    + "3 - Выход из программы");
            Scanner scanner0 = new Scanner(System.in);
            int answer0 = scanner0.nextInt();
            if (answer0 == 1) {
                while (true) {
                    System.out.println("Введите кэшируемую директорию или \"exit\":");
                    Scanner scanner = new Scanner(System.in);
                    String dir = scanner.nextLine();
                    if (dir.equals("exit")) {
                        break;
                    }
                    if (!new File(dir).isDirectory()) {
                        System.out.println("Нет такой директории((");
                        continue;
                    }
                    DirFileCache dFC = new DirFileCache(dir);
                    doing(dFC);
                }
            } else if (answer0 == 2) {
                System.out.println("Данный путь получения файла находится в разработке!");
            } else if (answer0 == 3) {
                return;
            } else {
                System.out.println("Введите корректные данные(1, 2 или 3) !");
            }
        }
    }

    private static void doing(AbstractCache<String, String> aC) {
         int i = 0;
         while (i < 5) {
             System.out.println("Введите имя файла");
             Scanner scanner0 = new Scanner(System.in);
             String key = scanner0.nextLine();
             if (!aC.validationKey(key)) {
                 System.out.println("Файл не найден!");
                 i++;
                 continue;
             }
             String rsl = aC.load(key);
             try {
                 while (i < 5) {
                     System.out.println("Файл находиться в кеше.\n"
                             + "1 - Получить содержимое файла.\n"
                             + "2 - Загрузить в кеш ещё один файл.\n"
                             + "3 - Выход из директории");
                     Scanner scanner1 = new Scanner(System.in);
                     int answer = scanner1.nextInt();
                     if (answer == 1) {
                         System.out.println(rsl);
                     } else if (answer == 2) {
                         break;
                     } else if (answer == 3) {
                         return;
                     } else {
                         System.out.println("Введите корректные данные(1, 2 или 3) !");
                         i++;
                     }
                 }
             } catch (InputMismatchException e) {
                 e.printStackTrace();
                 System.out.println("Неверный формат ввода!");
                 i++;
             }
         }
    }
}