package com.example.T2Sdemo.container;

public class ContainerRequestDTO {
    private String client;
    private String container_number;
    private Integer type;
    private Boolean status;
    private String category;

    public ContainerRequestDTO(String client, String container_number, Integer type, Boolean status, String category) {
        this.client = client;
        this.container_number = container_number;
        this.type = type;
        this.status = status;
        this.category = category;
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

    public void setTupe(Integer type) {
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
