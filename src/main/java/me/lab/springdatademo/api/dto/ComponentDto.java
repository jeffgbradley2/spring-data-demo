package me.lab.springdatademo.api.dto;

import lombok.Data;

@Data
public class ComponentDto {
    private Long id;
    private String name;
    private String description;
    private Long productId;
}
