package ru.home.camunda.dmn.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.home.camunda.dmn.dto.InputDto;
import ru.home.camunda.dmn.dto.OutputDto;
import ru.home.camunda.dmn.service.CamundaService;

@Slf4j
@RestController
@RequestMapping("/start")
@RequiredArgsConstructor
public class CamundaController {


    private final CamundaService camundaService;

    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<OutputDto> execute(@RequestBody InputDto dto) {
        log.info("START CONTROLLER");
        OutputDto result = camundaService.executeDmn(dto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
