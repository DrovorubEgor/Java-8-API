package com.ua.foxminded.javaapi.printer;

import com.ua.foxminded.javaapi.model.Racer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacerPrinterTest {

    private static List<Racer> racers;
    private PrintStream consoleStream;
    private ByteArrayOutputStream outputStreamProgram;

    @BeforeAll
    static void createInstances() {
        racers = new ArrayList<>();
        racers.add(new Racer("Vasya", "Ferrari", Duration.ZERO));
        racers.add(new Racer("Nikolay", "Zhiguli", Duration.ZERO));
        racers.add(new Racer("Mihail", "Volga", Duration.ZERO));
        racers.add(new Racer("Elizabeth", "Zaporozhets", Duration.ZERO));
        racers.add(new Racer("Svetlana", "Niva", Duration.ZERO));
    }

    @BeforeEach
    void setStream() {

        consoleStream = System.out;
        outputStreamProgram = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamProgram));
    }

    @AfterEach
    void setInitialStream() {
        System.setOut(consoleStream);
    }

    @Test
    void print_shouldPrintListElementsWithSeparatingLine() {
        RacerListPrinter racerPrint = new RacerListPrinter(3);
        StringBuilder expected = new StringBuilder("1.Vasya     | Ferrari     | 0:00.000" + System.lineSeparator())
                .append("2.Nikolay   | Zhiguli     | 0:00.000" + System.lineSeparator())
                .append("3.Mihail    | Volga       | 0:00.000" + System.lineSeparator())
                .append("--------------------------------------" + System.lineSeparator())
                .append("4.Elizabeth | Zaporozhets | 0:00.000" + System.lineSeparator())
                .append("5.Svetlana  | Niva        | 0:00.000" + System.lineSeparator());
        racerPrint.print(racers);
        String actual = outputStreamProgram.toString();
        assertEquals(expected.toString(), actual);
    }

    @Test
    void print_shouldPrintEmptyList() {
        RacerListPrinter racerPrint = new RacerListPrinter(0);
        List<Racer> emptyList = new ArrayList<>();
        StringBuilder expected = new StringBuilder();
        racerPrint.print(emptyList);
        String actual = outputStreamProgram.toString();
        assertEquals(expected.toString(), actual);
    }

    @Test
    void print_shouldNotPrintSeparator_WhenSeparatingIndexEqualsRacersSize() {
        RacerListPrinter racerListPrinter = new RacerListPrinter(racers.size());
        StringBuilder expected = new StringBuilder("1.Vasya     | Ferrari     | 0:00.000" + System.lineSeparator())
                .append("2.Nikolay   | Zhiguli     | 0:00.000" + System.lineSeparator())
                .append("3.Mihail    | Volga       | 0:00.000" + System.lineSeparator())
                .append("4.Elizabeth | Zaporozhets | 0:00.000" + System.lineSeparator())
                .append("5.Svetlana  | Niva        | 0:00.000" + System.lineSeparator());
        racerListPrinter.print(racers);
        String actual = outputStreamProgram.toString();
        assertEquals(expected.toString(), actual, "Should not print separating line as nothing to highlight.");
    }

    @Test
    void print_shouldNotPrintSeparator_WhenSeparatorIndexBiggerThanListSize() {
        RacerListPrinter racerListPrinter = new RacerListPrinter(10);
        StringBuilder expected = new StringBuilder("1.Vasya     | Ferrari     | 0:00.000" + System.lineSeparator())
                .append("2.Nikolay   | Zhiguli     | 0:00.000" + System.lineSeparator())
                .append("3.Mihail    | Volga       | 0:00.000" + System.lineSeparator())
                .append("4.Elizabeth | Zaporozhets | 0:00.000" + System.lineSeparator())
                .append("5.Svetlana  | Niva        | 0:00.000" + System.lineSeparator());
        racerListPrinter.print(racers);
        String actual = outputStreamProgram.toString();
        assertEquals(expected.toString(), actual, "Should not print separating line.");
    }
}