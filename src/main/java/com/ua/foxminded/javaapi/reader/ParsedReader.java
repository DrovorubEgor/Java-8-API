package com.ua.foxminded.javaapi.reader;

import com.ua.foxminded.javaapi.parser.Parser;

import java.io.IOException;
import java.util.stream.Stream;

public class ParsedReader<T> implements Reader<T> {

    private final Reader<String> reader;
    private final Parser<T> parser;

    public ParsedReader(Reader<String> reader, Parser<T> parser) {
        this.parser = parser;
        this.reader = reader;
    }

    @Override
    public Stream<T> read() throws IOException {
        return reader.read()
                .map(parser::parse);
    }
}