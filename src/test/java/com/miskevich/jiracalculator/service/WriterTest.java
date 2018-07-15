package com.miskevich.jiracalculator.service;

import com.miskevich.jiracalculator.model.TaskDto;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.miskevich.jiracalculator.util.TestUtils.getTaskDto;
import static com.miskevich.jiracalculator.util.TestUtils.getTaskDtos;
import static org.junit.Assert.assertEquals;

public class WriterTest {

    private Writer writer;

    @Before
    public void init() {
        writer = new Writer();
    }

    @Test
    public void testWriteFile() {
        List<TaskDto> taskDtos = getTaskDtos();
        writer.writeFile(taskDtos);
    }

    @Test
    public void testMapTaskToString() {
        String expectedString = "London, 162.625, 149.625";
        TaskDto taskDto = getTaskDto();
        String actualString = writer.mapTaskDtoToString.apply(taskDto);
        assertEquals(expectedString, actualString);
    }

}