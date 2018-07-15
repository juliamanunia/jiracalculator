package com.miskevich.jiracalculator.service;

import com.miskevich.jiracalculator.model.TaskDto;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.Function;

public class Writer {

    private static final String DELIMITER = ", ";
    private static final String FILE_NAME = "result.txt";
    private static final String FILE_HEADER = "Team, Total Effort, Remaining Effort";

    public void writeFile(List<TaskDto> taskDtos) {

        try (PrintWriter printWriter = new PrintWriter(Files.newBufferedWriter(Paths.get(FILE_NAME)))) {
            printWriter.println(FILE_HEADER);
            for (TaskDto taskDto : taskDtos) {
                printWriter.println(mapTaskDtoToString.apply(taskDto));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    Function<TaskDto, String> mapTaskDtoToString = (taskDto) -> {
        StringJoiner joiner = new StringJoiner(DELIMITER);
        joiner.add(taskDto.getTeam().getValue());
        joiner.add(String.valueOf(taskDto.getTotalEffortDuration()));
        joiner.add(String.valueOf(taskDto.getRemainingEffortDuration()));
        return joiner.toString();
    };
}
