package com.ua.foxminded.javaapi.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class TimeInfo {

    private final String abbreviation;
    private final LocalDateTime time;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS");

    public TimeInfo(String abbreviation, LocalDateTime time) {
        this.abbreviation = abbreviation;
        this.time = time;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public LocalDateTime getTime() {
        return time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeInfo timeInfo = (TimeInfo) o;
        return Objects.equals(abbreviation, timeInfo.abbreviation) && Objects.equals(time, timeInfo.time);
    }

    @Override
    public int hashCode() {
        int result = abbreviation.hashCode();
        result = 31 * result + time.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return abbreviation + " " + FORMATTER.format(time);
    }
}
