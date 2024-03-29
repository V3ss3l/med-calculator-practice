# med-calculator-practice
REST API, основанное на Spring Boot, содержащее в себе 3 медицинских калькулятора.

Медицинские калькуляторы:
1. Шкала SOFA - Оценка органной недостаточности и риска смертности у пациентов в ОИТР по шкале SOFA (Sequential (Sepsis-related) Organ Failure Assessment). Оценка вероятности сепсиса (Сепсис-3) у пациентов в ОИТР;
2. Шкала HEART - Стратификация риска смерти, инфаркта миокарда, необходимости коронарной реваскуляризации в течение 6 недель у пациентов старше 21 года с недифференцированной грудной болью в отделениях неотложной помощи, у которых может быть предположен ОКС;
3. Шкала Чайлд Пью - Прогноз летальности при циррозе печени по шкале Чайлд-Пью (Child-Pugh).

В данном репозитории находятся:
- Контроллер, реализующий логику запросов;
- Сервисы к каждому калькулятору, содержащии в себе алгоритмы вычисления результатов;
- Модели сущностей, необходимых для общения backend части с frontend.

Передача информации и результатов вычисления реализована с помощью отправки JSON с сущностями внутри.
