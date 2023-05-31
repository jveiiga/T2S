package com.example.T2Sdemo.container;

import java.util.List;

import javax.persistence.*;

import com.example.T2Sdemo.movement.Movement;

@Table(name = "containers")
@Entity(name = "ContainerEntity")
public class Container {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(name = "client", nullable = false)
    private String client;
    
    @Column(name = "container_number", nullable = false)
    private String container_number;
    
    @Column(name = "type", nullable = false)
    private Integer type;
    
    @Column(name = "status", nullable = false)
    private Boolean status;
    
    @Column(name = "category", nullable = false)
    private String category;
    
    @OneToMany(mappedBy = "container")
    private List<Movement> movements;

    public Container() {

    }

    public Container(ContainerRequestDTO data) {
        this.client = data.getClient();
        this.container_number = data.getContainer_number();
        this.type = data.getType();
        this.status = data.getStatus();
        this.category = data.getCategory();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getContainer_number() {
        return container_number;
    }

    public void setContainer_number(String container_number) {
        this.container_number = container_number;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
