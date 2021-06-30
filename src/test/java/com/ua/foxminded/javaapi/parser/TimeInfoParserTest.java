package com.ua.foxminded.javaapi.parser;

import com.ua.foxminded.javaapi.model.TimeInfo;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TimeInfoParserTest {

    Parser<TimeInfo> parser = new TimeInfoParser();

    @Test
    void parse_shouldAcceptStringAndParseToTimeInfo() {
        String string = "MES2018-05-24_12:05:58";
        TimeInfo actual = parser.parse(string);
        TimeInfo expected = new TimeInfo("MES", LocalDateTime.of(2018, 5, 24, 12, 5, 58));
        assertEquals(actual, expected);
    }
}