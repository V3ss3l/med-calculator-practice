package com.med.calculator.services;

import com.med.calculator.models.ResultEntity;
import com.med.calculator.models.SofaParams;
import org.springframework.stereotype.Service;

@Service
public class SofaService {

    private int RespiratoryIndexCalculationToScore(int pao2, int fio2){
        if(fio2 == 0) return -1;
        int ri = (pao2/fio2)*100;
        if(ri >= 400) return 0;
        else if (ri < 400 && ri >= 300) return 1;
        else if (ri < 300 && ri >= 200) return 2;
        else if (ri < 200 && ri >= 100) return 3;
        else return 4;
    }

    private int PlatCalculationToScore(int plat){
        if(plat >= 150) return 0;
        else if(plat < 150 && plat >= 100) return 1;
        else if(plat < 100 && plat >= 50) return 2;
        else if(plat < 50 && plat >= 20) return 3;
        else return 4;
    }

    private int BiliCalculationToScore(int bili){
        if(bili<21) return 0;
        else if(bili >= 21 && bili<=32) return 1;
        else if(bili > 32 && bili<=101) return 2;
        else if(bili >= 102 && bili<=204) return 3;
        else return 4;
    }

    private int LiverParamsCalculationToScore(boolean type, int liverParam){
        if(type){ // Креатинин
            if(liverParam < 110) return  0;
            else if(liverParam >=110 && liverParam <= 170) return 1;
            else if(liverParam >170 && liverParam <= 299) return 2;
            else if(liverParam >=300 && liverParam <= 440) return 3;
            else return 4;
        }
        else { // Суточный диурез
            if(liverParam < 500 && liverParam >= 200) return 3;
            else if(liverParam < 200) return 4;
        }
        return -1;
    }

    public ResultEntity ResultCalculationToScore(SofaParams params){
        ResultEntity res = new ResultEntity();
        int respScore = RespiratoryIndexCalculationToScore(params.getPaO2(), params.getFio2());
        int platScore = PlatCalculationToScore(params.getPlatelets());
        int biliScore = BiliCalculationToScore(params.getBilirubin());
        int liverScore = LiverParamsCalculationToScore(params.isLiverCheck(), params.getLiverParam());

        if(liverScore == -1 || respScore == -1) return null;

        int resultCalc = respScore + platScore + biliScore + liverScore + params.getHypotensia() + params.getGcs();
        res.setResult(resultCalc);

        if(resultCalc == 2) {
            res.setInfo("Летальность: 10%");
        }
        else if(resultCalc>2 && resultCalc<9){
            res.setInfo("Летальность: <33%");
        }
        else if(resultCalc>=9 && resultCalc<=11){
            res.setInfo("Летальность: 40 - 50%");
        }
        else if(resultCalc>11){
            res.setInfo("Летальность: 95%");
        }
        return res;
    }
}
