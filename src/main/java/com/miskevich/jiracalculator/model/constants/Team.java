package com.miskevich.jiracalculator.model.constants;

public enum Team {

    INDIA("India"),
    KIEV("Kiev"),
    LONDON("London"),
    NY("NY"),
    UI("UI");

    private String value;

    Team(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Team getTeamByName(String teamName) {
        for (Team team : values()) {
            if (team.value.equalsIgnoreCase(teamName)) {
                return team;
            }
        }
        throw new IllegalArgumentException(String.format("Team with name %s is not allowed in input file!", teamName));
    }
}
