package com.miskevich.jiracalculator.service;

import com.miskevich.jiracalculator.model.Task;
import com.miskevich.jiracalculator.model.constants.Status;
import com.miskevich.jiracalculator.model.constants.Team;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reader {

    private static final String LINE_SEPARATOR = ",";
    private static final int STATUS_INDEX = 4;
    private static final int DURATION_INDEX = 6;
    private static final int TEAM_INDEX = 8;
    private String fileName;

    public Reader(String fileName) {
        this.fileName = fileName;
    }

    public Map<Team, Map<Status, Integer>> readAndGroupCsv() {

        Map<Team, Map<Status, Integer>> tasksByTeamAndStatus;

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            tasksByTeamAndStatus = stream.parallel().skip(1).map(mapToTask)
                    .collect(Collectors.groupingBy(Task::getTeam,
                            Collectors.groupingBy(Task::getStatus,
                                    Collectors.summingInt(Task::getDuration))));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return tasksByTeamAndStatus;
    }

    Function<String, Task> mapToTask = (line) -> {
        String[] splittedLine = line.split(LINE_SEPARATOR);
        return new Task.TaskBuilder()
                .withStatus(Status.getStatusByName(splittedLine[STATUS_INDEX]))
                .withDuration(Integer.parseInt(splittedLine[DURATION_INDEX]))
                .withTeam(Team.getTeamByName(splittedLine[TEAM_INDEX]))
                .build();
    };
}
