package com.ua.foxminded.javaapi.reader;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class ResourceFileReaderTest {

    private final static String TEST_RACER_INFO_FILE = "testRacerInfo.txt";
    private final Reader<String> fileReader = new ResourceFileReader(TEST_RACER_INFO_FILE);

    @Test
    void read_shouldReadDataFromFile_CastToStreamStrings() throws Exception {
        List<String> actual = fileReader.read().collect(Collectors.toList());
        List<String> expected = Arrays.asList("DRR_Daniel Ricciardo_RED BULL RACING TAG HEUER",
                "SVF_Sebastian Vettel_FERRARI",
                "LHM_Lewis Hamilton_MERCEDES");
        assertEquals(actual, expected);
    }
}