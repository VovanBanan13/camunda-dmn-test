package ru.home.camunda.dmn.service;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.dmn.engine.DmnDecision;
import org.camunda.bpm.dmn.engine.DmnDecisionTableResult;
import org.camunda.bpm.dmn.engine.DmnEngine;
import org.camunda.bpm.dmn.engine.DmnEngineConfiguration;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.model.dmn.Dmn;
import org.camunda.bpm.model.dmn.DmnModelInstance;
import org.camunda.commons.utils.IoUtil;
import org.springframework.stereotype.Component;
import ru.home.camunda.dmn.dto.InputDto;
import ru.home.camunda.dmn.dto.OutputDto;

import java.io.InputStream;

@Slf4j
@Component
public class CamundaService {

    public OutputDto executeDmn(InputDto inputDto) {
        log.info("START SERVICE");
        DmnEngine dmnEngine = DmnEngineConfiguration.createDefaultDmnEngineConfiguration().buildEngine();
        InputStream inputStream = IoUtil.fileAsStream("scoring_dmn.xml");
        DmnModelInstance modelInstance = Dmn.readModelFromStream(inputStream);
        DmnDecision decision = dmnEngine.parseDecision("scoring", modelInstance);

        VariableMap variables = Variables
                .putValue("inn", inputDto.getInn())
                .putValue("region", inputDto.getRegion())
                .putValue("capital", inputDto.getCapital());

        DmnDecisionTableResult result = dmnEngine.evaluateDecisionTable(decision, variables);
        log.info("RESULT DMN: {}", result.getSingleResult().get("Status"));

        return OutputDto.builder()
                .name(inputDto.getName())
                .inn(inputDto.getInn())
                .region(inputDto.getRegion().toString())
                .capital(inputDto.getCapital().toString())
                .status((Boolean) result.getSingleResult().get("Status"))
                .build();
    }
}
