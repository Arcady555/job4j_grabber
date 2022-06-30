package ru.job4j.ood.lsp;

public class Example2 {
    public static void main(String[] args) {
        Drive drive = new MotoDrive();
        drive.setFuelConsumption(8);
        System.out.println(drive.road(199, 16));
    }
}

class Drive {
    private int fuel;
    private int fuelConsumption;

    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public int road(int distance, int fuel) {
        int rsl = (fuel / fuelConsumption * 100) - distance;
        if (rsl < 20) {
            throw new IllegalArgumentException("Need more fuel!");
        }
        return rsl;
    }
}

class MotoDrive extends Drive {
    private int fuel;
    private int fuelConsumption;

    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public int road(int distance, int fuel) {
        int rsl = (fuel / fuelConsumption * 100) - distance;
        if (rsl < 2) {
            throw new IllegalArgumentException("Need more fuel!");
        }
        return rsl;
    }
}