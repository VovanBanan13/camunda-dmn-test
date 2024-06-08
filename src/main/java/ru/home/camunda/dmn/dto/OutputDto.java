package ru.home.camunda.dmn.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class OutputDto {
    private String name;
    private boolean status;
    private String region;
    private String inn;
    private String capital;
}
