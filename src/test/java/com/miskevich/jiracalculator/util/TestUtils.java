package com.miskevich.jiracalculator.util;

import com.miskevich.jiracalculator.model.Task;
import com.miskevich.jiracalculator.model.TaskDto;
import com.miskevich.jiracalculator.model.constants.Status;
import com.miskevich.jiracalculator.model.constants.Team;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestUtils {

    public static Map<Team, Map<Status, Integer>> getTasksByTeamAndStatus() {
        return new HashMap<Team, Map<Status, Integer>>() {{
            put(Team.LONDON, new HashMap<Status, Integer>() {{
                put(Status.CLOSED_COMPLETE, 59400);
                put(Status.OPEN, 45000);
            }});
            put(Team.INDIA, new HashMap<Status, Integer>() {{
                put(Status.OPEN, 111600);
            }});
            put(Team.UI, new HashMap<Status, Integer>() {{
                put(Status.CLOSED_COMPLETE, 28800);
                put(Status.OPEN, 230400);
            }});
        }};
    }

    public static Map<Team, Map<Status, Integer>> getTasksByTeamAndStatusShort() {
        return new HashMap<Team, Map<Status, Integer>>() {{
            put(Team.LONDON, new HashMap<Status, Integer>() {{
                put(Status.CLOSED_COMPLETE, 59400);
                put(Status.OPEN, 45000);
            }});
        }};
    }

    public static List<TaskDto> getTaskDtos() {
        return new ArrayList<TaskDto>() {{
            add(new TaskDto.TaskDtoBuilder()
                    .withTeam(Team.LONDON)
                    .withTotalEffortDuration(3.625)
                    .withRemainingEffortDuration(1.5625)
                    .build());

            add(new TaskDto.TaskDtoBuilder()
                    .withTeam(Team.INDIA)
                    .withTotalEffortDuration(3.875)
                    .withRemainingEffortDuration(3.875)
                    .build());

            add(new TaskDto.TaskDtoBuilder()
                    .withTeam(Team.UI)
                    .withTotalEffortDuration(9.0)
                    .withRemainingEffortDuration(8.0)
                    .build());
        }};
    }

    public static List<TaskDto> getTaskDtosShort() {
        return new ArrayList<TaskDto>() {{
            add(new TaskDto.TaskDtoBuilder()
                    .withTeam(Team.LONDON)
                    .withTotalEffortDuration(3.625)
                    .withRemainingEffortDuration(1.5625)
                    .build());
        }};
    }

    public static TaskDto getTaskDto() {
        return new TaskDto.TaskDtoBuilder()
                .withTeam(Team.LONDON)
                .withTotalEffortDuration(162.625)
                .withRemainingEffortDuration(149.625)
                .build();
    }

    public static Task getTask() {
        return new Task.TaskBuilder()
                .withTeam(Team.LONDON)
                .withStatus(Status.OPEN)
                .withDuration(28800)
                .build();
    }
}
