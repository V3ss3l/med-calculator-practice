package com.med.calculator.services;

import com.med.calculator.models.ChildPhewParams;
import com.med.calculator.models.ResultEntity;
import com.med.calculator.models.SofaParams;
import org.springframework.stereotype.Service;

@Service
public class ChildPhewService implements CalculatorService<ChildPhewParams>{
    @Override
    public ResultEntity CalculateScore(ChildPhewParams params) {
        if(params == null) return null;
        int score = params.getBilirubin() + params.getAlbumin() + params.getMho()+  params.getAscit() + params.getEnceph();
        return ResultCalculation(score);
    }

    @Override
    public ResultEntity ResultCalculation(int score) {
        ResultEntity res = new ResultEntity();
        res.setResult(score);
        if(score < 7) res.setInfo("Класс A. Продолжительность жизни: 15-20 лет. Периоперационная летальность при абдоминальных операциях: 10%.");
        else if(score < 10) res.setInfo("Класс B. Значительное функциональное ухудшение. Периоперационная летальность при абдоминальных операциях: 30%.");
        else res.setInfo("Класс C. Продолжительность жизни: 1-3 года. Периоперационная летальность при абдоминальных операциях: 82%.");
        return res;
    }
}
