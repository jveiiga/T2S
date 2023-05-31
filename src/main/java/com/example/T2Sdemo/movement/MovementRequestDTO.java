package com.example.T2Sdemo.movement;

import java.time.LocalDateTime;

import com.example.T2Sdemo.container.Container;

public class MovementRequestDTO {
    private String movement_type;
    private LocalDateTime start_time_date;
    private LocalDateTime end_time_date;
    // private Container container;
    private Long container_id;

    public MovementRequestDTO(String movement_type, LocalDateTime start_time_date, LocalDateTime end_time_date, Container container, Long container_id) {
        this.movement_type = movement_type;
        this.container_id = container_id;
    }

    public String getMovementType() {
        return movement_type;
    }

    public void setMovementType(String movement_type) {
        this.movement_type = movement_type;
    }

    public LocalDateTime getStartTimeDate() {
        return start_time_date;
    }

    public void setStartTimeDate(LocalDateTime start_time_date) {
        this.start_time_date = start_time_date;
    }

    public LocalDateTime getEndTimeDate() {
        return end_time_date;
    }

    public void setEndTimeDate(LocalDateTime end_time_date) {
        this.end_time_date = end_time_date;
    }

    // public Container getContainer() {
    //     return container;
    // }

    // public void setContainer(Container container) {
    //     this.container = container;
    // }

    public Long getContainerId() {
        return container_id;
    }

    public void setContainerId(Long container_id) {
        this.container_id = container_id;
    }
}

