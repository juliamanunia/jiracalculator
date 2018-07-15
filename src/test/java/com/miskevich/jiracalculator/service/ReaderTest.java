package com.miskevich.jiracalculator.service;

import com.miskevich.jiracalculator.model.Task;
import com.miskevich.jiracalculator.model.constants.Status;
import com.miskevich.jiracalculator.model.constants.Team;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Paths;
import java.util.Map;

import static com.miskevich.jiracalculator.util.TestUtils.getTask;
import static com.miskevich.jiracalculator.util.TestUtils.getTasksByTeamAndStatus;
import static org.junit.Assert.assertEquals;

public class ReaderTest {

    private static final String TEST_FILE_NAME = String.valueOf(Paths.get("src", "test", "resources", "unit-test.csv"));
    private Reader reader;

    @Before
    public void init() {
        reader = new Reader(TEST_FILE_NAME);
    }

    @Test
    public void testReadAndGroupCsv() {
        Map<Team, Map<Status, Integer>> expectedTasksByTeamAndStatus = getTasksByTeamAndStatus();

        Map<Team, Map<Status, Integer>> actualTasksByTeamAndStatus = reader.readAndGroupCsv();
        assertEquals(expectedTasksByTeamAndStatus, actualTasksByTeamAndStatus);
    }

    @Test
    public void testMapToTask() {
        Task expectedTask = getTask();
        String line = "MCPU-10140,2748508,2660783,QA Design- Notify Parties Assignment Confirmed,Open,Sub-task,28800,Medium,London";

        Task actualTask = reader.mapToTask.apply(line);
        assertEquals(expectedTask.getTeam(), actualTask.getTeam());
        assertEquals(expectedTask.getStatus(), actualTask.getStatus());
        assertEquals(expectedTask.getDuration(), actualTask.getDuration());
    }

}