package com.miskevich.jiracalculator.service;

import com.miskevich.jiracalculator.model.TaskDto;
import com.miskevich.jiracalculator.model.constants.Status;
import com.miskevich.jiracalculator.model.constants.Team;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static com.miskevich.jiracalculator.util.TestUtils.getTaskDtosShort;
import static com.miskevich.jiracalculator.util.TestUtils.getTasksByTeamAndStatusShort;
import static org.junit.Assert.assertEquals;

public class ConverterTest {

    @Test
    public void testConvertGroupedResult() {
        Map<Team, Map<Status, Integer>> tasksByTeamAndStatus = getTasksByTeamAndStatusShort();
        List<TaskDto> expectedTaskDtos = getTaskDtosShort();

        List<TaskDto> actualTaskDtos = Converter.convertGroupedResult(tasksByTeamAndStatus);
        for (TaskDto taskDto : expectedTaskDtos) {
            assertEquals(taskDto.getTeam(), actualTaskDtos.get(0).getTeam());
            assertEquals(taskDto.getTotalEffortDuration(), actualTaskDtos.get(0).getTotalEffortDuration(), 0);
            assertEquals(taskDto.getRemainingEffortDuration(), actualTaskDtos.get(0).getRemainingEffortDuration(), 0);
        }
    }

    @Test
    public void testConvertSecondsToDays() {
        double expectedDays = 3.875;

        double actualDays = Converter.convertSecondsToDays.apply(111600);
        assertEquals(expectedDays, actualDays, 0);
    }

}