package ru.job4j.ood.lsp;

public class Example1 {
    public static void main(String[] args) {
        Grandfather grandfather = new Son(19);
        System.out.println(grandfather.canAlcohol());
    }
}

class Grandfather {
    private int age;

    public Grandfather(int age) {
        this.age = age;
    }

    public boolean canAlcohol() {
        return true;
    }
}

class Father extends Grandfather {
    private int age;

    public Father(int age) {
        super(age);
    }

    public boolean canAlcohol() {
        return true;
    }
}

class Son extends Father {
    private int age;

    public Son(int age) {
        super(age);
    }

    public boolean canAlcohol() {
        return age > 21;
    }
}
