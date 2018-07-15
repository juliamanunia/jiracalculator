package com.miskevich.jiracalculator.model;

import com.miskevich.jiracalculator.model.constants.Status;
import com.miskevich.jiracalculator.model.constants.Team;

public class Task {

    private Team team;
    private Status status;
    private int duration;

    private Task(TaskBuilder taskBuilder) {
        this.team = taskBuilder.team;
        this.status = taskBuilder.status;
        this.duration = taskBuilder.duration;
    }

    public Team getTeam() {
        return team;
    }

    public Status getStatus() {
        return status;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Task{" +
                "team=" + team +
                ", status=" + status +
                ", duration=" + duration +
                '}';
    }

    public static class TaskBuilder {

        private Team team;
        private Status status;
        private int duration;

        public TaskBuilder withTeam(Team team) {
            this.team = team;
            return this;
        }

        public TaskBuilder withStatus(Status status) {
            this.status = status;
            return this;
        }

        public TaskBuilder withDuration(int duration) {
            this.duration = duration;
            return this;
        }

        public Task build() {
            return new Task(this);
        }
    }
}
