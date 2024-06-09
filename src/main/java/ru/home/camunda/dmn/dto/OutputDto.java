package ru.home.camunda.dmn.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class OutputDto {
    private String name;
    private Boolean status;
    private String inn;
    private String region;
    private String capital;
}
