package com.miskevich.jiracalculator.model.constants;

import org.junit.Test;

import static com.miskevich.jiracalculator.model.constants.Team.LONDON;
import static org.junit.Assert.assertEquals;

public class TeamTest {

    @Test
    public void getTeamByNameSuccess() {
        Team actualTeam = Team.getTeamByName("London");
        assertEquals(LONDON, actualTeam);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getTeamByNameException() {
        Team.getTeamByName("Invalid");
    }

}