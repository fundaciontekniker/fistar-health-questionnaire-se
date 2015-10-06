curl -H "Content-Type: application/json" -H "token: token1" -X POST  127.0.0.1:8080/questionnaire.mng.rest/rest/ktek/questionnaire/configuration -d '
{    "KtekQuestionnaireConfiguration": {        "idquestionnaireconfiguration": 1,        "typesave": 5,        "endpointserver": "10.0.0.0",        "eventserviceoauth2headertoken": "",        "timeout": 5000,        "port": 1026    }}'

