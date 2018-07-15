package com.miskevich.jiracalculator.service;

import com.miskevich.jiracalculator.model.TaskDto;
import com.miskevich.jiracalculator.model.constants.Status;
import com.miskevich.jiracalculator.model.constants.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static com.miskevich.jiracalculator.model.constants.Status.CLOSED_COMPLETE;
import static com.miskevich.jiracalculator.model.constants.Status.CLOSED_REJECTED;

public final class Converter {

    /**
     * 28800 = 60 (convert seconds to minutes) * 60 (convert minutes to hours) * 8 (convert hours to working days).
     */
    private static final int SECOND_TO_DAY_MULTIPLIER = 28800;

    private Converter() {
    }

    public static List<TaskDto> convertGroupedResult(Map<Team, Map<Status, Integer>> tasksByTeamAndStatus) {
        List<TaskDto> taskDtos = new ArrayList<>();

        for (Map.Entry<Team, Map<Status, Integer>> teamWithStatuses : tasksByTeamAndStatus.entrySet()) {
            Team team = teamWithStatuses.getKey();
            Map<Status, Integer> statusesWithDuration = teamWithStatuses.getValue();

            int totalEffortDuration = statusesWithDuration.values().stream().parallel().mapToInt(e -> e).sum();
            int remainingEffortDuration = statusesWithDuration.entrySet().stream()
                    .parallel()
                    .filter(e -> !(e.getKey() == CLOSED_COMPLETE || e.getKey() == CLOSED_REJECTED))
                    .mapToInt(Map.Entry::getValue).sum();

            TaskDto taskDto = new TaskDto.TaskDtoBuilder()
                    .withTeam(team)
                    .withTotalEffortDuration(convertSecondsToDays.apply(totalEffortDuration))
                    .withRemainingEffortDuration(convertSecondsToDays.apply(remainingEffortDuration))
                    .build();
            taskDtos.add(taskDto);
        }
        return taskDtos;
    }

    static Function<Integer, Double> convertSecondsToDays = (seconds) -> ((double) seconds / SECOND_TO_DAY_MULTIPLIER);
}
