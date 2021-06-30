package com.ua.foxminded.javaapi.service;

import com.ua.foxminded.javaapi.model.Racer;
import com.ua.foxminded.javaapi.model.RacerInfo;
import com.ua.foxminded.javaapi.model.TimeInfo;

import java.time.Duration;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacerProcessor implements Processor<Racer> {

    private final Map<String, TimeInfo> startTime;
    private final Map<String, TimeInfo> endTime;
    private final Stream<RacerInfo> racersInfo;

    public RacerProcessor(Stream<RacerInfo> racersInfo, Stream<TimeInfo> startTime, Stream<TimeInfo> endTime) {
        this.racersInfo = racersInfo;
        this.startTime = startTime
                .collect(Collectors.toMap(TimeInfo::getAbbreviation, Function.identity()));
        this.endTime = endTime
                .collect(Collectors.toMap(TimeInfo::getAbbreviation, Function.identity()));
    }

    public List<Racer> process() {
        return racersInfo.map( item -> createRacer(item.getName(),
                        item.getCarName(),
                        calculateDuration(startTime.get(item.getAbbreviation()), endTime.get(item.getAbbreviation()))
                        )
                ).sorted(Comparator.comparing(Racer::getLapTime).reversed())
                .collect(Collectors.toList());
    }

    private Racer createRacer(String name, String carName, Duration duration) {
        return new Racer(name, carName, duration);
    }

    private Duration calculateDuration(TimeInfo start, TimeInfo end) {
        return Duration.between(end.getTime(), start.getTime());
    }
}
