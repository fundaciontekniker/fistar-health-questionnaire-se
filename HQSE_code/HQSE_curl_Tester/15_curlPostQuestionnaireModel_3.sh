curl -X POST -H "Content-Type: application/json" -H "token: token1" 127.0.0.1/questionnaire.mng.rest/rest/ktek/questionnaire/questionnairemodel -d '{ "KtekQuestionnaireResultEntity": { "idquestionnaire": 3, "iduserquestionnaireplanning":403, "codtelecareprogram": "BD", "coduser": "User1", "listsections": [ { "idquestionnairesection": 2, "listitems": [ { "idquestionnaireitem": 9, "listcodanswer": "A1"  }] } ] } }'
