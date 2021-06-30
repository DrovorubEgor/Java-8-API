package com.ua.foxminded.javaapi.reader;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

public class ResourceFileReader implements Reader<String> {

    private final String fileName;

    public ResourceFileReader(final String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Stream<String> read() throws FileNotFoundException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
        if (inputStream == null) {
            throw new FileNotFoundException("The file has not found.");
        }
        InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        return new BufferedReader(reader).lines();
    }
}
