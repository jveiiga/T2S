package com.example.T2Sdemo.container;

public class ContainerRespondeDTO {
    private Long id;
    private String client;
    private String container_number;
    private Integer type;
    private Boolean status;
    private String category;

    public ContainerRespondeDTO(Container container) {
        this.id = container.getId();
        this.client = container.getClient();
        this.container_number = container.getContainer_number();
        this.type = container.getType();
        this.status = container.getStatus();
        this.category = container.getCategory();
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
