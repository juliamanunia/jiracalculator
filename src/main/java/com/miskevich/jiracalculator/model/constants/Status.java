package com.miskevich.jiracalculator.model.constants;

public enum Status {

    CLOSED_COMPLETE("Closed - Complete"),
    CLOSED_REJECTED("Closed - Rejected"),
    IN_PROGRESS("In Progress"),
    OPEN("Open");

    private String value;

    Status(String value) {
        this.value = value;
    }

    public static Status getStatusByName(String statusName) {
        for (Status status : values()) {
            if (status.value.equalsIgnoreCase(statusName)) {
                return status;
            }
        }
        throw new IllegalArgumentException(String.format("Status with name %s is not allowed in input file!", statusName));
    }
}
