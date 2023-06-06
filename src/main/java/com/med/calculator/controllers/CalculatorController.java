package com.med.calculator.controllers;

import com.med.calculator.models.InfoEntity;
import com.med.calculator.models.ResultEntity;
import com.med.calculator.models.SofaParams;
import com.med.calculator.services.SofaService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@Slf4j
public class CalculatorController {

    private final SofaService sofaService;

    CalculatorController(SofaService sofaService) {
        this.sofaService = sofaService;
    }
    @RequestMapping(
            value = "/calculator/info",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public ResponseEntity<InfoEntity> getInfo(){
        var entity = new InfoEntity();
        entity.setInfo("HELLO!!!");
        return new ResponseEntity<InfoEntity>(entity, HttpStatusCode.valueOf(200));
    }

    @RequestMapping(
            value = "/calculator/sofa",
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity<ResultEntity> CalculateSofaScore(@RequestBody SofaParams params){
        log.info("Sofa Params - {}", params);
        ResultEntity result = sofaService.ResultCalculationToScore(params);
        log.info("CalcResult - {}", result);
        if (result != null) {
            return new ResponseEntity<ResultEntity>(result, HttpStatusCode.valueOf(200));
        }
        else return new ResponseEntity<ResultEntity>(HttpStatusCode.valueOf(204));
    }

    /*@RequestMapping(
            value = "/calculator/sofa/info",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public ResponseEntity<InfoEntity> ShowSofaCalcInfo(){
    }*/
}
