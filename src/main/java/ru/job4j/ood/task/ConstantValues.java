package ru.job4j.ood.task;

import java.text.SimpleDateFormat;

public final class ConstantValues {
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd:MM:yyyy HH:mm");
    public static final int DIVIDER_ACCOUTER = 1000;
    public static final SimpleDateFormat DATE_FORMAT_FOF_SERIALISATION
            = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

    private ConstantValues() {
    }
}
