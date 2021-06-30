package com.ua.foxminded.javaapi.reader;

import com.ua.foxminded.javaapi.parser.Parser;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ParsedReaderTest {

    private final Reader mockReader = Mockito.mock(Reader.class);
    private final Parser<Integer> mockParser = Mockito.mock(Parser.class);
    private final ParsedReader<Integer> collector = new ParsedReader<>(mockReader, mockParser);

    @Test
    void read_shouldAcceptReaderAndParser_returnStreamRacerInfo() throws Exception {
        when(mockReader.read()).thenReturn(Stream.of("1", "2", "3"));
        when(mockParser.parse("1")).thenReturn(1);
        when(mockParser.parse("2")).thenReturn(2);
        when(mockParser.parse("3")).thenReturn(3);
        List<Integer> actual = collector.read()
                .collect(Collectors.toList());
        List<Integer> expected = Arrays.asList(1, 2, 3);
        assertEquals(expected, actual);
    }
}