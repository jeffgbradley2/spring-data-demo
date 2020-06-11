package me.lab.springdatademo.api.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Long customerId;
    private List<ComponentDto> components = new ArrayList<>();
}
