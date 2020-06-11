package me.lab.springdatademo.domain.shared;

import lombok.Data;

@Data
public class SearchCriteria {
    private String key;
    private OperationType operation;
    private String value;
}
