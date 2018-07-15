package com.miskevich.jiracalculator.model.constants;

import org.junit.Test;

import static com.miskevich.jiracalculator.model.constants.Status.OPEN;
import static org.junit.Assert.assertEquals;

public class StatusTest {

    @Test
    public void testGetStatusByNameSuccess() {
        Status actualStatus = Status.getStatusByName("Open");
        assertEquals(OPEN, actualStatus);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetStatusByNameException() {
        Status.getStatusByName("Invalid");
    }
}