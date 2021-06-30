package com.ua.foxminded.javaapi;

import com.ua.foxminded.javaapi.reader.ParsedReader;
import com.ua.foxminded.javaapi.model.Racer;
import com.ua.foxminded.javaapi.parser.RacerInfoParser;
import com.ua.foxminded.javaapi.parser.TimeInfoParser;
import com.ua.foxminded.javaapi.printer.Printer;
import com.ua.foxminded.javaapi.printer.RacerListPrinter;
import com.ua.foxminded.javaapi.reader.ResourceFileReader;
import com.ua.foxminded.javaapi.service.RacerProcessor;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        Printer<List<Racer>> printer = new RacerListPrinter(15);
        printer.print(
                new RacerProcessor(
                        new ParsedReader<>(
                                new ResourceFileReader("abbreviations.txt"),
                                new RacerInfoParser()
                        ).read(),
                        new ParsedReader<>(
                                new ResourceFileReader("start.log"),
                                new TimeInfoParser()
                        ).read(),
                        new ParsedReader<>(
                                new ResourceFileReader("end.log"),
                                new TimeInfoParser()
                        ).read()
                ).process()
        );
    }
}
