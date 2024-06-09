package ru.home.camunda.dmn.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.home.camunda.dmn.dto.OutputDto;
import ru.home.camunda.dmn.model.ScoringEntity;
import ru.home.camunda.dmn.repository.ScoringRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class ElasticSearchService {

    private final ScoringRepository repository;

    public void save(OutputDto outputDto) {
        ScoringEntity entity = ScoringEntity.builder()
                .name(outputDto.getName())
                .status(outputDto.getStatus())
                .inn(outputDto.getInn())
                .region(outputDto.getRegion())
                .capital(outputDto.getCapital())
                .build();
        repository.save(entity);
        log.info("SAVE ENTITY: {}", entity);
    }
}
