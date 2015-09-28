curl -H "Content-Type: application/json" -H "token: token1" -X POST  127.0.0.1:8080/questionnaire.mng.rest/rest/ktek/questionnaire/configuration -d '
{    "KtekQuestionnaireConfiguration": {        "idquestionnaireconfiguration": 1,        "typesave": 5,        "endpointserver": "193.144.237.236",        "eventserviceoauth2headertoken": "",        "timeout": 5000,        "port": 1026    }}'

