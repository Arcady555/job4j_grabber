package ru.job4j.gc;

public class User {

    private String name;
    private boolean sex;
    private int age;

    public User() {
    }

    public User(int age) {
        this.age = age;
    }

    public User(String name, boolean sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Removed %d%n", age);
    }
}
