package com.example.T2Sdemo.movement;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.persistence.*;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.example.T2Sdemo.container.Container;
import com.example.T2Sdemo.container.ContainerRepository;

@Table(name = "movements")
@Entity(name = "MovementEntity")

public class Movement {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "movement_type", nullable = false)
    private String movement_type;

    @Column(name = "start_time_date", nullable = false)
    private LocalDateTime start_time_date;

    @Column(name = "end_time_date", nullable = false)
    private LocalDateTime end_time_date;

    @ManyToOne
    @JoinColumn(name = "container_id")
    private Container container;

    public Movement() {

    }

    public Movement(MovementRequestDTO movementRequestDTO, ContainerRepository containerRepository) {
        this.movement_type = movementRequestDTO.getMovementType();
        this.start_time_date = LocalDateTime.now();
        this.end_time_date = LocalDateTime.now();
        
        Long containerId = movementRequestDTO.getContainerId();
        Optional<Container> containerOptional = containerRepository.findById(containerId);
        if(containerOptional.isPresent()) {
            this.container = containerOptional.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Container not found");
        }
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

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }
}
