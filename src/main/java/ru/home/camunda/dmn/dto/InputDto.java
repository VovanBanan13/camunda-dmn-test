package ru.home.camunda.dmn.dto;

import lombok.Data;

@Data
public class InputDto {
    private String name;
    private String inn;
    private Integer region;
    private Long capital;
}
