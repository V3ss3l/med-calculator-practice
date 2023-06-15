package com.med.calculator.controllers;

import com.med.calculator.models.*;
import com.med.calculator.services.ChildPhewService;
import com.med.calculator.services.HeartService;
import com.med.calculator.services.SofaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@Tag(name="Контроллер калькуляторов", description = "Данный контроллер обрабатывает запросы, связанные с медицинскими калькуляторами")
public class CalculatorController {

    private final HashMap<String, String> infoMap = new HashMap<>();
    private final SofaService sofaService;
    private final ChildPhewService childService;

    private final HeartService heartService;

    CalculatorController(SofaService sofaService, ChildPhewService childService, HeartService heartService) {
        infoMap.put("sofa", "Оценка органной недостаточности и риска смертности у пациентов в ОИТР по шкале SOFA (Sequential (Sepsis-related) Organ Failure Assessment). Оценка вероятности сепсиса (Сепсис-3) у пациентов в ОИТР.");
        infoMap.put("heart", "Стратификация риска смерти, инфаркта миокарда, необходимости коронарной реваскуляризации в течение 6 недель у пациентов старше 21 года с недифференцированной грудной болью в отделениях неотложной помощи, у которых может быть предположен ОКС");
        infoMap.put("child", "Прогноз летальности при циррозе печени по шкале Чайлд-Пью (Child-Pugh)");
        this.sofaService = sofaService;
        this.childService = childService;
        this.heartService = heartService;
    }
    @RequestMapping(
            value = "/calculator/sofa/info",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    @Operation(summary = "Получение информации о калькуляторе SOFA", description = "Данный метод обрабатывает запросы по получению краткой информации о калькуляторе SOFA. Возвращает JSON с сущностью InfoEntity, хранящей информацию")
    public ResponseEntity<InfoEntity> getSofaInfo(){
        var entity = new InfoEntity();
        entity.setInfo(infoMap.get("sofa"));
        return new ResponseEntity<InfoEntity>(entity, HttpStatusCode.valueOf(200));
    }

    @RequestMapping(
            value = "/calculator/heart/info",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    @Operation(summary = "Получение информации о калькуляторе HEART", description = "Данный метод обрабатывает запросы по получению краткой информации о калькуляторе HEART. Возвращает JSON с сущностью InfoEntity, хранящей информацию")
    public ResponseEntity<InfoEntity> getHeartInfo(){
        var entity = new InfoEntity();
        entity.setInfo(infoMap.get("heart"));
        return new ResponseEntity<InfoEntity>(entity, HttpStatusCode.valueOf(200));
    }

    @RequestMapping(
            value = "/calculator/child-phew/info",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    @Operation(summary = "Получение информации о калькуляторе Чайлд Пью", description = "Данный метод обрабатывает запросы по получению краткой информации о калькуляторе Чайлд Пью. Возвращает JSON с сущностью InfoEntity, хранящей информацию")
    public ResponseEntity<InfoEntity> getChildPhewInfo(){
        var entity = new InfoEntity();
        entity.setInfo(infoMap.get("child"));
        return new ResponseEntity<InfoEntity>(entity, HttpStatusCode.valueOf(200));
    }

    @RequestMapping(
            value = "/calculator/sofa",
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json"
    )
    @Operation(summary = "Подсчет баллов по шкале SOFA", description = "Данный метод обрабатывает запросы, связанные с подсчетом баллов по данному критерию. Принимает и отправляет - JSON. Результат вычисления содержится в сущности ResultEntity в поле result.")
    public ResponseEntity<ResultEntity> CalculateSofaScore(@RequestBody @Parameter(name = "Параметры для шкалы SOFA") SofaParams params){
        log.info("Sofa Params - {}", params);
        ResultEntity result = sofaService.ResultCalculationToScore(params);
        log.info("CalcResult - {}", result);
        if (result != null) {
            return new ResponseEntity<ResultEntity>(result, HttpStatusCode.valueOf(200));
        }
        else return new ResponseEntity<ResultEntity>(HttpStatusCode.valueOf(204));
    }

    @RequestMapping(
            value = "/calculator/child-phew",
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json"
    )
    @Operation(summary = "Подсчет баллов по шкале Чайлд Пью", description = "Данный метод обрабатывает запросы, связанные с подсчетом баллов по данному критерию. Принимает и отправляет - JSON. Результат вычисления содержится в сущности ResultEntity в поле result.")
    public ResponseEntity<ResultEntity> CalculateChildPhewScore(@RequestBody @Parameter(name = "Параметры для шкалы Чайлд Пью") ChildPhewParams params){
        log.info("ChildPhew Params - {}", params);
        ResultEntity result = childService.ResultCalculationToScore(params);
        log.info("CalcResult - {}", result);
        if (result != null) {
            return new ResponseEntity<ResultEntity>(result, HttpStatusCode.valueOf(200));
        }
        else return new ResponseEntity<ResultEntity>(HttpStatusCode.valueOf(204));
    }

    @RequestMapping(
            value = "/calculator/heart",
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json"
    )
    @Operation(summary = "Подсчет баллов по шкале HEART", description = "Данный метод обрабатывает запросы, связанные с подсчетом баллов по данному критерию. Принимает и отправляет - JSON. Результат вычисления содержится в сущности ResultEntity в поле result.")
    public ResponseEntity<ResultEntity> CalculateHeartScore(@RequestBody @Parameter(name = "Параметры для шкалы HEART") HeartParams params){
        log.info("Heart Params - {}", params);
        ResultEntity result = heartService.ResultCalculationToScore(params);
        log.info("CalcResult - {}", result);
        if (result != null) {
            return new ResponseEntity<ResultEntity>(result, HttpStatusCode.valueOf(200));
        }
        else return new ResponseEntity<ResultEntity>(HttpStatusCode.valueOf(204));
    }
}
