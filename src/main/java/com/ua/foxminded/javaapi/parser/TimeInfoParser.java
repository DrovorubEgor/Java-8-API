package com.ua.foxminded.javaapi.parser;

import com.ua.foxminded.javaapi.model.TimeInfo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TimeInfoParser implements Parser<TimeInfo> {

    private final static int ABBREVIATION = 3;
    private final static int LOCAL_DATE = 13;
    private final static int LOCAL_TIME = 14;

    @Override
    public TimeInfo parse(String string) {
        return new TimeInfo(string.substring(0, ABBREVIATION), LocalDateTime.of(
                LocalDate.parse(string.substring(ABBREVIATION, LOCAL_DATE)),
                LocalTime.parse(string.substring(LOCAL_TIME)))
        );
    }
}