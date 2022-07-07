package ru.job4j.ood.isp;

public interface OS {
    void sensorScreen();
}

class Windows implements OS {

    @Override
    public void sensorScreen() {
    }
}

class Linux implements OS {

    @Override
    public void sensorScreen() {
    }
}

class MacOs implements OS {

    @Override
    public void sensorScreen() {
    }
}
