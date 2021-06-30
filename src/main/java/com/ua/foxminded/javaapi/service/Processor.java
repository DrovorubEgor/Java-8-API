package com.ua.foxminded.javaapi.service;

import java.util.List;

public interface Processor<T> {

    List<T> process();
}
