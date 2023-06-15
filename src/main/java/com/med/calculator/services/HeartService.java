package com.med.calculator.services;

import com.med.calculator.models.ChildPhewParams;
import com.med.calculator.models.HeartParams;
import com.med.calculator.models.ResultEntity;
import org.springframework.stereotype.Service;

@Service
public class HeartService {

    public ResultEntity ResultCalculationToScore(HeartParams params){
        ResultEntity res = new ResultEntity();
        int resultScore = params.getAge() + params.getAnamnez() + params.getEcg() +  params.getRiskFactor() + params.getTroponin();
        res.setResult(resultScore);
        if(params.getTroponin() > 0) res.setAddInfo("Если тропонин положительный, многие эксперты рекомендуют госпиталицию и дальнейший осмотр и наблюдение.");
        if(resultScore >= 0 && resultScore < 4) res.setInfo("0.9 - 1.7% риск ОССС. 0.99% (ретроспективный анализ), 1.7% (проспективный анализ) пациентов были выписаны.");
        else if(resultScore >= 4 && resultScore < 7) res.setInfo("12 - 16.6% риск ОССС. 11.6% (ретроспективный анализ), 16.6% (проспективный анализ) пациентов были госпитализированы.");
        else if(resultScore >= 7) res.setInfo("50 - 65% риск ОССС. 65.2% (ретроспективный анализ), 50.1% (проспективный анализ) пациентов - кандидаты на раннее инвазивное вмешательство.");
        return res;
    }
}
