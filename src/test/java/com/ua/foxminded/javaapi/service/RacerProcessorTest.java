package com.ua.foxminded.javaapi.service;

import com.ua.foxminded.javaapi.model.Racer;
import com.ua.foxminded.javaapi.model.RacerInfo;
import com.ua.foxminded.javaapi.model.TimeInfo;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RacerProcessorTest {

    private final Stream<RacerInfo> racerInfoStream = Stream.of(
            new RacerInfo("DRR", "Daniel Ricciardo", "RED BULL RACING TAG HEUER"),
            new RacerInfo("SVF", "Sebastian Vettel", "FERRARI"),
            new RacerInfo("LHM", "Lewis Hamilton", "MERCEDES")
    );
    private final Stream<TimeInfo> startInfoStream = Stream.of(
            new TimeInfo("DRR", LocalDateTime.of(2018, 5, 24, 12, 14, 12)),
            new TimeInfo("SVF", LocalDateTime.of(2018, 5, 24, 12, 2, 59)),
            new TimeInfo("LHM", LocalDateTime.of(2018, 5, 24, 12, 18, 20))
    );
    private final Stream<TimeInfo> endInfoStream = Stream.of(
            new TimeInfo("DRR", LocalDateTime.of(2018, 5, 24, 12, 15, 24)),
            new TimeInfo("SVF", LocalDateTime.of(2018, 5, 24, 12, 4, 3)),
            new TimeInfo("LHM", LocalDateTime.of(2018, 5, 24, 12, 19, 32))
    );

    @Test
    void process_shouldHandleStreamsDataToRacerList() {
        Processor<Racer> racerProcessor = new RacerProcessor(racerInfoStream, startInfoStream, endInfoStream);
        List<Racer> actual = racerProcessor.process();
        List<Racer> expected = new ArrayList<>();
        expected.add(new Racer("Sebastian Vettel", "FERRARI", Duration.parse("PT-1M-04S")));
        expected.add(new Racer("Daniel Ricciardo", "RED BULL RACING TAG HEUER", Duration.parse("PT-1M-12S")));
        expected.add(new Racer("Lewis Hamilton", "MERCEDES", Duration.parse("PT-1M-12S")));
        assertEquals(expected, actual);
    }
}