package com.ua.foxminded.javaapi.model;

public class RacerInfo {

    private final String abbreviation;
    private final String name;
    private final String carName;

    public RacerInfo(String abbreviation, String name, String carName) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.carName = carName;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getName() {
        return name;
    }

    public String getCarName() {
        return carName;
    }

    @Override
    public int hashCode() {
        int result = abbreviation.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + carName.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacerInfo racerInfo = (RacerInfo) o;
        return abbreviation.equals(racerInfo.abbreviation) && name.equals(racerInfo.name) && carName.equals(racerInfo.carName);
    }

    @Override
    public String toString() {
        return abbreviation + " " + name + " " + carName;
    }
}
