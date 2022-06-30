package ru.job4j.ood.lsp;

public class Example3 {
    public static void main(String[] args) {
        PensionTheOrganization pTO = new PensionTheOrganization(68);
        System.out.println(pTO.pensionAccrual(60));
    }
}

class Pension {
    private int age;
    private int experience;

    public Pension(int age) {
        this.age = age;
    }

    public int pensionAccrual(int experience) {
        if (age - experience < 16 && experience < 0) {
            throw new IllegalArgumentException("Invalid data");
        }
        int pensionAmount = 0;
        if (experience == 0) {
            pensionAmount = 50;
        } else if (experience < 20) {
            pensionAmount = 200;
        } else if (experience < 40) {
            pensionAmount = 300;
        } else {
            pensionAmount = 350;
        }
        return pensionAmount;
    }
}

class PensionTheOrganization extends Pension {
    private int age;
    private int experience;

    public PensionTheOrganization(int age) {
        super(age);
    }

    public int pensionAccrual(int experience) {
        if (experience < 0) {
            throw new IllegalArgumentException("Invalid data");
        }
        int pensionAmount;
        if (experience == 0) {
            pensionAmount = 50;
        } else if (experience < 20) {
            pensionAmount = 250;
        } else if (experience < 40) {
            pensionAmount = 350;
        } else {
            pensionAmount = 400;
        }
        return pensionAmount;
    }
}
