package com.ua.foxminded.javaapi.reader;

import java.io.IOException;
import java.util.stream.Stream;

public interface Reader<T> {

    Stream<T> read() throws IOException;
}