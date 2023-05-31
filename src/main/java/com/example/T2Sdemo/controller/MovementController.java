package com.example.T2Sdemo.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.example.T2Sdemo.container.Container;
import com.example.T2Sdemo.container.ContainerRepository;
import com.example.T2Sdemo.movement.Movement;
import com.example.T2Sdemo.movement.MovementRepository;
import com.example.T2Sdemo.movement.MovementRequestDTO;
import com.example.T2Sdemo.movement.MovementResponseDTO;

@RestController
@RequestMapping("movements")
public class MovementController {
    
    private final MovementRepository repository;
    private final ContainerRepository containerRepository;
    
    @Autowired
    public MovementController(MovementRepository repository, ContainerRepository containerRepository) {
        this.repository = repository;
        this.containerRepository = containerRepository;
    }

    @CrossOrigin(origins =  "*", allowedHeaders = "*")
    @DeleteMapping("/{movementId}")
    public ResponseEntity<?> delete(@PathVariable Long movementId) {

        Optional<Movement> optionalMovement = repository.findById(movementId);
        if(!optionalMovement.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById((movementId));

        return ResponseEntity.noContent().build();
    }

    @CrossOrigin(origins =  "*", allowedHeaders = "*")
    @PatchMapping("/{movementId}")
    public ResponseEntity<Movement> patch(@PathVariable Long movementId, @RequestBody Map<String, Object> patchData) {

        if(!repository.existsById(movementId)) {
            return ResponseEntity.notFound().build();
        }

        Movement movement = repository.findById(movementId).orElse(null);

        if(movement == null) {
            return ResponseEntity.notFound().build();
        }

        if(patchData.containsKey("movement_type")) {
            movement.setMovementType((String) patchData.get("movement_type"));
        }

        if(patchData.containsKey("container_id")) {
            movement.setContainer((Container) patchData.get("container_id"));
        }

        Movement patchMovement = repository.save(movement);

        return ResponseEntity.ok(patchMovement);
    }

    @CrossOrigin(origins =  "*", allowedHeaders = "*")
    @PostMapping
    public Movement post(@RequestBody MovementRequestDTO data) {

        Long containerId = data.getContainerId();
        Container container = containerRepository.findById(containerId).orElse(null);
        if(container == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Container not found");
        }

        Movement movementData = new Movement(data, containerRepository);
        Movement postMovement = repository.save(movementData);

        return postMovement;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<MovementResponseDTO> get() {

        List<MovementResponseDTO> movementList = repository.findAll().stream().map(MovementResponseDTO::new).collect(Collectors.toList());
        return movementList;
    }
}
