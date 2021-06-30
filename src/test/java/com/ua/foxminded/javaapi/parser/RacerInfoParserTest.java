package com.ua.foxminded.javaapi.parser;

import com.ua.foxminded.javaapi.model.RacerInfo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RacerInfoParserTest {

    Parser<RacerInfo> parser = new RacerInfoParser();

    @Test
    void parse_shouldAcceptStringAndParseToRacerInfo() {
        String string = "DRR_Daniel Ricciardo_RED BULL RACING TAG HEUER";
        RacerInfo actual = parser.parse(string);
        RacerInfo expected = new RacerInfo("DRR", "Daniel Ricciardo", "RED BULL RACING TAG HEUER");
        assertEquals(actual, expected);
    }
}