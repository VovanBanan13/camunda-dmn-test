package ru.home.camunda.dmn.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import ru.home.camunda.dmn.model.ScoringEntity;

@Repository
public interface ScoringRepository extends ElasticsearchRepository<ScoringEntity, String> {
}
