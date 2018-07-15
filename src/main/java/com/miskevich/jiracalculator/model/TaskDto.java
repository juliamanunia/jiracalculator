package com.miskevich.jiracalculator.model;

import com.miskevich.jiracalculator.model.constants.Team;

public class TaskDto {

    private Team team;
    private double totalEffortDuration;
    private double remainingEffortDuration;

    private TaskDto(TaskDtoBuilder taskDtoBuilder) {
        this.team = taskDtoBuilder.team;
        this.totalEffortDuration = taskDtoBuilder.totalEffortDuration;
        this.remainingEffortDuration = taskDtoBuilder.remainingEffortDuration;
    }

    public Team getTeam() {
        return team;
    }

    public double getTotalEffortDuration() {
        return totalEffortDuration;
    }

    public double getRemainingEffortDuration() {
        return remainingEffortDuration;
    }

    @Override
    public String toString() {
        return "TaskDto{" +
                "team=" + team +
                ", totalEffortDuration=" + totalEffortDuration +
                ", remainingEffortDuration=" + remainingEffortDuration +
                '}';
    }

    public static class TaskDtoBuilder {

        private Team team;
        private double totalEffortDuration;
        private double remainingEffortDuration;

        public TaskDtoBuilder withTeam(Team team) {
            this.team = team;
            return this;
        }

        public TaskDtoBuilder withTotalEffortDuration(double totalEffortDuration) {
            this.totalEffortDuration = totalEffortDuration;
            return this;
        }

        public TaskDtoBuilder withRemainingEffortDuration(double remainingEffortDuration) {
            this.remainingEffortDuration = remainingEffortDuration;
            return this;
        }

        public TaskDto build() {
            return new TaskDto(this);
        }

    }
}
