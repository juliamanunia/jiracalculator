package com.miskevich.jiracalculator;

import com.miskevich.jiracalculator.model.TaskDto;
import com.miskevich.jiracalculator.model.constants.Status;
import com.miskevich.jiracalculator.model.constants.Team;
import com.miskevich.jiracalculator.service.Converter;
import com.miskevich.jiracalculator.service.Reader;
import com.miskevich.jiracalculator.service.Writer;

import java.util.List;
import java.util.Map;

public class AppRunner {

    public static void main(String[] args) {

        Reader reader = new Reader(args[0]);
        Map<Team, Map<Status, Integer>> tasksByTeamAndStatus = reader.readAndGroupCsv();

        List<TaskDto> taskDtos = Converter.convertGroupedResult(tasksByTeamAndStatus);

        Writer writer = new Writer();
        writer.writeFile(taskDtos);
    }
}
