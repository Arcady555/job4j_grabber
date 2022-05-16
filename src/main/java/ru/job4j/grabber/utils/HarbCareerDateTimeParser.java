package ru.job4j.grabber.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class HarbCareerDateTimeParser implements DateTimeParser {

    @Override
    public LocalDateTime parse(String parse) {
        String[] dateTime = parse.split("T");
        String[] date = dateTime[0].split("-");
        String[] time = dateTime[1].split(":", 3);

        return LocalDateTime.of(
                LocalDate.of(
                        Integer.parseInt(date[0]),
                        Integer.parseInt(date[1]),
                        Integer.parseInt(date[2])),
                LocalTime.of(
                        Integer.parseInt(time[0]),
                        Integer.parseInt(time[1]),
                        Integer.parseInt(time[2])
                )
        );
    }
}