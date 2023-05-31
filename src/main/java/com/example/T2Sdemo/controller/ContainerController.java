package com.example.T2Sdemo.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.T2Sdemo.container.Container;
import com.example.T2Sdemo.container.ContainerRepository;
import com.example.T2Sdemo.container.ContainerRequestDTO;
import com.example.T2Sdemo.container.ContainerRespondeDTO;


@RestController
@RequestMapping("containers")
public class ContainerController {
    
    @Autowired
    private ContainerRepository repository;

    @CrossOrigin(origins =  "*", allowedHeaders = "*")
    @DeleteMapping("/{containerId}")
    public ResponseEntity<?> delete(@PathVariable Long containerId) {
        //Verificar se container com o ID fornecido existe no banco de dados
        Optional<Container> optionalContainer = repository.findById(containerId);
        if(!optionalContainer.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(containerId);
        
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin(origins =  "*", allowedHeaders = "*")
    @PatchMapping("/{containerId}")
    public ResponseEntity<Container> patch(@PathVariable Long containerId, @RequestBody Map<String, Object> patchData) {
        //Verificar se o container com o ID fornecido existe no banco de dados
        if(!repository.existsById(containerId)) {
            return ResponseEntity.notFound().build();
        }

        //Consultar no repositório para buscar um Objeto Container com base no ID fornecido
        Container container = repository.findById(containerId).orElse(null);

        if(container == null) {
            return ResponseEntity.notFound().build();
        }

        //Verificar os campos
        if(patchData.containsKey("client")) {
            container.setClient((String) patchData.get("client"));
        }

        if(patchData.containsKey("container_number")) {
            container.setContainer_number((String) patchData.get("container_number"));
        }

        if(patchData.containsKey("type")) {
            container.setType((Integer) patchData.get("type"));
        }

        if(patchData.containsKey("status")) {
            container.setStatus((Boolean) patchData.get("status"));
        }

        if(patchData.containsKey("category")) {
            container.setCategory((String) patchData.get("category"));
        }

        Container patchContainer = repository.save(container);

        return ResponseEntity.ok(patchContainer);
    }
    
    @CrossOrigin(origins =  "*", allowedHeaders = "*")
    @PostMapping
    public Container post(@RequestBody ContainerRequestDTO data) {
        Container containerData = new Container(data);
        Container postContainer = repository.save(containerData);

        return postContainer;
    }

    @CrossOrigin(origins =  "*", allowedHeaders = "*")
    @GetMapping
    public List<ContainerRespondeDTO> get() {

        List<ContainerRespondeDTO> containersList = repository.findAll().stream().map(ContainerRespondeDTO::new).collect(Collectors.toList());
        return containersList;
    }
}
