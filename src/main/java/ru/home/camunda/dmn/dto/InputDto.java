package ru.home.camunda.dmn.dto;

import lombok.Data;

@Data
public class InputDto {
    private String name;
    private Integer region;
    private String inn;
    private Long capital;
}
