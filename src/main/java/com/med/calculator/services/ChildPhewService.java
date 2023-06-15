package com.med.calculator.services;

import com.med.calculator.models.ChildPhewParams;
import com.med.calculator.models.ResultEntity;
import com.med.calculator.models.SofaParams;
import org.springframework.stereotype.Service;

@Service
public class ChildPhewService {

    public ResultEntity ResultCalculationToScore(ChildPhewParams params){
        ResultEntity res = new ResultEntity();
        int resultScore = params.getBilirubin() + params.getAlbumin() + params.getMho()+  params.getAscit() + params.getEnceph();
        res.setResult(resultScore);
        if(resultScore < 7) res.setInfo("Класс A. Продолжительность жизни: 15-20 лет. Периоперационная летальность при абдоминальных операциях: 10%.");
        else if(resultScore < 10) res.setInfo("Класс B. Значительное функциональное ухудшение. Периоперационная летальность при абдоминальных операциях: 30%.");
        else res.setInfo("Класс C. Продолжительность жизни: 1-3 года. Периоперационная летальность при абдоминальных операциях: 82%.");
        return res;
    }
}
