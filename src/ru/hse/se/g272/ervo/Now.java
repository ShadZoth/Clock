package ru.hse.se.g272.ervo;

import java.util.Calendar;

public class Now {

    public static int getSeconds() {
        return Calendar.getInstance().get(Calendar.SECOND);
    }

    public static int getMinutes() {
        return Calendar.getInstance().get(Calendar.MINUTE);
    }

    public static int getHours() {
        return Calendar.getInstance().get(Calendar.HOUR);
    }
}
