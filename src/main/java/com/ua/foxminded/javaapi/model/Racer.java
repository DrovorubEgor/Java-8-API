package com.ua.foxminded.javaapi.model;

import java.time.Duration;
import java.util.Objects;

public class Racer {

    private final String name;
    private final String carName;
    private final Duration lapTime;

    public Racer(String name, String carName, Duration lapTime) {
        this.name = name;
        this.carName = carName;
        this.lapTime = lapTime;
    }

    public String getName() {
        return name;
    }

    public String getCarName() {
        return carName;
    }

    public Duration getLapTime() {
        return lapTime;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + carName.hashCode();
        result = 31 * result + lapTime.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Racer racer = (Racer) o;
        return Objects.equals(name, racer.name) && Objects.equals(carName, racer.carName) && Objects.equals(lapTime, racer.lapTime);
    }

    @Override
    public String toString() {
        return name + " " + carName + " " + lapTime;
    }
}
