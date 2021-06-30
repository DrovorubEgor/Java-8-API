package com.ua.foxminded.javaapi.parser;

import com.ua.foxminded.javaapi.model.RacerInfo;

public class RacerInfoParser implements Parser<RacerInfo> {

    private final static int ABBREVIATION_POSITION = 0;
    private final static int NAME_POSITION = 1;
    private final static int TEAM_POSITION = 2;

    @Override
    public RacerInfo parse(String string) {
        String[] parts = string.split("_");
        return new RacerInfo(parts[ABBREVIATION_POSITION], parts[NAME_POSITION], parts[TEAM_POSITION]);
    }
}
