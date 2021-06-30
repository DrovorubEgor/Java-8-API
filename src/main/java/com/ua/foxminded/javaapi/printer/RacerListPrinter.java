package com.ua.foxminded.javaapi.printer;

import com.ua.foxminded.javaapi.model.Racer;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

public class RacerListPrinter implements Printer<List<Racer>>{

    private final static String PATTERN = "m:ss.SSS";
    private final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(PATTERN);
    private final int separatingIndex;

    public RacerListPrinter(final int separatingIndex) {
        this.separatingIndex = separatingIndex;
    }

    @Override
    public void print(List<Racer> racers) {
        final int maxNameLength = getMaxFieldLength(racers, Racer::getName);
        final int maxCarNameLength = getMaxFieldLength(racers, Racer::getCarName);
        final int numberIndex = calculateNumberLength(racers.size());
        final AtomicInteger counter = new AtomicInteger(0);

        final String formatString = "%" + numberIndex + "d.%-" + maxNameLength + "s | %-" + maxCarNameLength + "s | %-1s%n";

        racers.stream()
                .map( racer -> String.format(formatString,
                        counter.incrementAndGet(),
                        racer.getName(),
                        racer.getCarName(),
                        FORMATTER.format(LocalTime.MIDNIGHT.minus(racer.getLapTime())))
                ).peek( line -> {
                    if (counter.get() == separatingIndex + 1){
                        System.out.printf("%s%n", getCharacters(line.length(), '-'));
                    }
                })
                .forEach(System.out::print);
    }

    private String getCharacters(int length, char character) {
        char[] array = new char[length];
        Arrays.fill(array, character);
        return new String(array);
    }

    private int getMaxFieldLength(List<Racer> racers, Function<Racer, String> fieldGetter) {
        return racers.stream()
                .map(fieldGetter)
                .mapToInt(String::length)
                .max()
                .orElse(0);
    }

    private int calculateNumberLength(final int number){
        return number == 0 ? 1 : (int) Math.log10(number) + 1;
    }
}
