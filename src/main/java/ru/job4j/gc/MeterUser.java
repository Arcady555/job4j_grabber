package ru.job4j.gc;

public class MeterUser {
    public static void main(String[] args) {
        User user0 = new User();
        User[] users = new User[] {new User(),
                new User(49),
                new User("Arkady", true, 49),
                new User("Masha", false, 40),
                new User("Vica", false, 11),
                new User("Roma", true, 2),
                new User("M", true, 2)
        };
        for (User user : users) {
            System.out.println("Объект " + user + " занимает " + getByte(user) + " байт памяти");
        }
    }

    private static int getByte(User user) {
        int rsl = 7;
        int nameByte = user.getName() == null ? 0 : 29 + user.getName().length() * 2;
        int sexByte = 1;
        int ageByte = user.getAge() == 0 ? 0 : 2;
        rsl += nameByte + sexByte + ageByte;
        return rsl;
    }
}
