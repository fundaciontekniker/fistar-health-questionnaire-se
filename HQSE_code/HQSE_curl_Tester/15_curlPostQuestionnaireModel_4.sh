curl -X POST -H "Content-Type: application/json" -H "token: token1" 127.0.0.1:8080/questionnaire.mng.rest/rest/ktek/questionnaire/questionnairemodel -d '{ "KtekQuestionnaireResultEntity": { "idquestionnaire": 4, "iduserquestionnaireplanning":769, "codtelecareprogram": "BD", "coduser": "User1", "listsections": [ { "idquestionnairesection": 3, "listitems": [ { "idquestionnaireitem": 10, "answervalue": "headache"  }] } ] } }'
