package ru.home.camunda.dmn.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Builder
@Document(indexName = "scoring")
public class ScoringEntity {
    @Id
    private String id;
    @Field(type = FieldType.Text)
    private String name;
    @Field(type = FieldType.Boolean)
    private Boolean status;
    @Field(type = FieldType.Text)
    private String inn;
    @Field(type = FieldType.Text)
    private String region;
    @Field(type = FieldType.Text)
    private String capital;
}
