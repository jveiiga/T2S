package com.example.T2Sdemo.movement;

import java.time.LocalDateTime;

public class MovementResponseDTO {
    private Long id;
    private String movement_type;
    private LocalDateTime start_time_date;
    private LocalDateTime end_time_date;
    private Long containerId;

    public MovementResponseDTO(Movement movement) {
        this.id = movement.getId();
        this.movement_type = movement.getMovementType();
        this.start_time_date = movement.getStartTimeDate();
        this.end_time_date = movement.getEndTimeDate();
        this.containerId = movement.getContainer().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getContainerId() {
        return containerId;
    }

    public void setContainerId(Long containerId) {
        this.containerId = containerId;
    }
}
