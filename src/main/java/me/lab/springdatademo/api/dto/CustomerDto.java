package me.lab.springdatademo.api.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CustomerDto {
    private Long id;
    private String name;
    private List<ProductDto> products = new ArrayList<>();
}
