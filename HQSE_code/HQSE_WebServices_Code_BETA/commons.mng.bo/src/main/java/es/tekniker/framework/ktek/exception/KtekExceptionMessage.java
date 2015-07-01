/*
*
* Copyright 2015 IK4-Tekniker All Rights Reserved
*
* This file is part of Health Questionnaire SE at FISTAR https://www.fi-star.eu/  
*
* Health Questionnaire SE is free software: you can redistribute it and/or
* modify it under the terms of the GNU Affero General Public License as
* published by the Free Software Foundation, either version 3 of the
* License, or (at your option) any later version.
*
* Health Questionnaire SE is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero
* General Public License for more details.
*
* You should have received a copy of the GNU Affero General Public License
* along with Health Questionnaire SE. If not, see http://www.gnu.org/licenses/.
*
* For those usages not covered by this license please contact with
* patricia.casla at tekniker dot es
*
* Author: Ignacio Lazaro Llorente
*/
package es.tekniker.framework.ktek.exception;

public class KtekExceptionMessage {
	
	public static String EXCEPTION_CODE_ROLE_NO_VALID="code_role_no_valid";
	public static String EXCEPTION_CODE_ROLE_NO_DATA_DEFINED_FOR_ROLE="code_role_no_data_defined_for_role";
	
	public static String EXCEPTION_CODE_LOGIN_REQUIRED_DATA_NO_DEFINED="code_login_required_data_no_defined";
	public static String EXCEPTION_CODE_LOGIN_NO_DATA_DEFINED_FOR_USER="code_login_no_data_defined_for_user";
	public static String EXCEPTION_CODE_LOGIN_USERDATASESSION_CREATION_ERROR="code_login_userdatasession_creation_error";
	public static String EXCEPTION_CODE_LOGIN_USER_DOES_NOT_EXIST="code_login_user_does_not_exist";
	public static String EXCEPTION_CODE_LOGIN_USER_NOT_ASSCOCIATED_TO_TELECAREPROGRAM="code_login_user_not_associated_to_telecareprogram";
	public static String EXCEPTION_CODE_LOGIN_TOKEN_EXPIRED="code_login_token_expired";
	public static String EXCEPTION_CODE_LOGIN_TOKEN_NOT_VALID="code_login_token_not_valid";
	public static String EXCEPTION_CODE_LOGIN_SETTINGS_NOT_DEFINED="code_login_settings_not_defined";
	public static String EXCEPTION_CODE_LOGIN_PASSWORD_NOT_RIGHT="code_login_password_not_right";
	
	public static String EXCEPTION_CODE_LEARNING_LEARNINGMODULE_DOES_NOT_EXISTS="code_learningmodule_does_not_exist";
	public static String EXCEPTION_CODE_LEARNING_LEARNINGSESSION_DOES_NOT_EXISTS="code_learningsession_does_not_exist";	
	public static String EXCEPTION_CODE_LEARNING_LEARNINGEXERCISE_DOES_NOT_EXISTS="code_learningexercise_does_not_exist";
	public static String EXCEPTION_CODE_LEARNING_LEARNINGRESULTEXERCISE_DOES_NOT_EXISTS="code_learningexercise_does_not_exist";
	public static String EXCEPTION_CODE_LEARNING_USAGEPARAMETERTYPE_NOT_VALID="code_learningusageparametertype_not_valid";
	
	public static String EXCEPTION_CODE_USER_PROGRAM_DOES_NOT_EXIST="code_userprogram_does_not_exist";
	
	public static String EXCEPTION_AUTENTICATION_MODE_EXTERNAL_NOT_IMPLEMENTED="code_authentication_mode_external_not_implemented";
	
	public static String EXCEPTION_CODE_TOKEN_VALUE_NO_DEFINED="code_token_value_no_defined";
	public static String EXCEPTION_CODE_IDLANG_VALUE_NO_DEFINED="code_idLang_value_no_defined";
	public static String EXCEPTION_CODE_LEARNINGMODULE_VALUE_NO_DEFINED="code_learningmodule_value_no_defined";
	public static String EXCEPTION_CODE_LEARNINGSESSION_VALUE_NO_DEFINED="code_learningsession_value_no_defined";
	public static String EXCEPTION_CODE_LEARNINGEXERCISE_VALUE_NO_DEFINED="code_learningexercise_value_no_defined";
	public static String EXCEPTION_CODE_USERPROGRAM_VALUE_NO_DEFINED="code_userprogram_value_no_defined";
	public static String EXCEPTION_CODE_STATUS_VALUE_NO_DEFINED="code_status_value_no_defined";
	public static String EXCEPTION_CODE_LOGIN_USER_VALUE_NO_DEFINED="code_login_user_value_no_defined";
	
	public static String EXCEPTION_CODE_TELECARE_PROGRAM_DOES_NOT_EXIST="code_telecareprogram_does_not_exist";
	public static String EXCEPTION_CODE_USER_EXT_DOES_NOT_EXIST="code_user_ext_does_not_exist";
	
	public static String EXCEPTION_CODE_QUESTIONNAIRE_SECTION_DOES_NOT_EXIST="questionnaire_section_does_not_exist";
	public static String EXCEPTION_CODE_QUESTIONNAIRE_SECTION_NOT_ALL_DEFINED="questionnaire_section_not_all_defined";
	public static String EXCEPTION_CODE_QUESTIONNAIRE_SECTION_NOT_DEFINED="questionnaire_section_not_defined";
	public static String EXCEPTION_CODE_QUESTIONNAIRE_ITEMS_DOES_NOT_EXIST="questionnaire_items_does_not_exist";
	public static String EXCEPTION_CODE_QUESTIONNAIRE_ITEM_NOT_DEFINED="questionnaire_item_not_defined";
	public static String EXCEPTION_CODE_QUESTIONNAIRE_QUESTION_DOES_NOT_EXISTS="questionnaire_question_does_not_exist";
	public static String EXCEPTION_CODE_QUESTIONNAIRE_ANSWER_NOT_RIGHT="questionnaire_answer_not_right";
	public static String EXCEPTION_CODE_QUESTIONNAIRE_DOES_NOT_EXIST="questionnaire_does_not_exist";
	public static String EXCEPTION_CODE_QUESTIONNAIRE_RESULT_INSERT_ERROR="questionnaire_result_insert_error";
	public static String EXCEPTION_CODE_QUESTIONNAIRE_ANSWER_DOES_NOT_EXIST="questionnaire_answer_does_not_exist";
	
		
	public static String EXCEPTION_CODE_STATUS_LEARNING_UPDATE_ERROR="status_learning_update_error";
	public static String EXCEPTION_CODE_STATUS_LEARNING_UPDATE_MAX_NUMBER_TRIALS="status_learning_update_max_number_trials";
	
	public static String EXCEPTION_CODE_STATUS_LEARNING_UPDATE_STATUS_NEXT_ERROR="status_learning_update_status_next_error";
	public static String EXCEPTION_CODE_STATUS_EXERCISE_UPDATE_ERROR_FOR_LEARNING_SESSION="status_exercise_update_error_for_learning_session";
	
	public static String EXCEPTION_CODE_USER_DOES_NOT_EXIST="code_user_does_not_exist";
	public static String EXCEPTION_CODE_USER_CREATE_ERROR = "code_user_create_error";
	public static String EXCEPTION_CODE_USER_CREATE_DATA_REQUIRED_NOT_DEFINED = "code_user_create_data_required_not_defined";
	public static String EXCEPTION_CODE_USER_ERROR_DELETE_USER = "code_user_error_delete_user";	
	public static String EXCEPTION_CODE_USER_ERROR_DELETE_USER_SESSION_DATA = "code_user_error_delete_user_session_data";	
	
	public static String EXCEPTION_CODE_QUESTIONNAIRE_TYPE_NOT_ASSESSMENT="questionnaire_type_not_assessment";
	public static String EXCEPTION_CODE_QUESTIONNAIRE_TYPE_NOT_MONITORING="questionnaire_type_not_monitoring";
	
	public static String EXCEPTION_CODE_QUESTIONNAIRE_PARAMETER_VALUE_NOT_VALID="questionnaire_parameter_value_not_valid";
	public static String EXCEPTION_CODE_QUESTIONNAIRE_MONITORING_SCHEDULE_DATA_NOT_DEFINED="questionnaire_monitoring_schedule_data_not_defined";
	public static String EXCEPTION_CODE_QUESTIONNAIRE_DATEVALIDFROM_NOT_DEFINED="questionnaire_datevalidfrom_not_defined";
	public static String EXCEPTION_CODE_QUESTIONNAIRE_DATEVALIDTO_NOT_DEFINED="questionnaire_datevalidto_not_defined";
	public static String EXCEPTION_CODE_QUESTIONNAIRE_PERIODICITYVALUE_NOT_DEFINED="questionnaire_periodicityvalue_not_defined";
	public static String EXCEPTION_CODE_QUESTIONNAIRE_COMPLETIONINTERVALVALUE_NOT_DEFINED="questionnaire_completionintervalvalue_not_defined";
	public static String EXCEPTION_CODE_QUESTIONNAIRE_RESULT_DOES_NOT_EXIST="questionnaire_result_does_not_exist";

	public static final String EXCEPTION_CODE_IDUSER_VALUE_NO_DEFINED = "iduser_no_defined";
	public static final String EXCEPTION_CODE_IDPROFESSIONAL_VALUE_NO_DEFINED = "idprofessional_no_defined";
	public static final String EXCEPTION_CODE_IDPATIENT_VALUE_NO_DEFINED = "idpatient_no_defined";
	public static final String EXCEPTION_CODE_IDTELECAREPROGRAM_VALUE_NO_DEFINED = "idtelecareprogram_no_defined";
	public static final String EXCEPTION_CODE_IDUSERPROGRAM_VALUE_NO_DEFINED = "iduserprogram_no_defined";
	public static final String EXCEPTION_CODE_IDEXERCISE_VALUE_NO_DEFINED = "idexercise_no_defined";
	public static final String EXCEPTION_CODE_IDLEARNINGMODULE_VALUE_NO_DEFINED = "idlearningmodule_no_defined";
	public static final String EXCEPTION_CODE_IDLEARNINGSESSION_VALUE_NO_DEFINED = "idlearningsession_no_defined";
	public static final String EXCEPTION_CODE_IDRESULTEXERCISE_VALUE_NO_DEFINED = "idresultexercise_no_defined";
	
	public static final String EXCEPTION_CODE_IDQUESTIONNAIRE_VALUE_NO_DEFINED = "idquestionnaire_no_defined";
	
	public static final String EXCEPTION_CODE_DATEFROM_VALUE_NO_DEFINED = "datefrom_no_defined";
	public static final String EXCEPTION_CODE_DATETO_VALUE_NO_DEFINED = "dateto_no_defined";
	public static final String EXCEPTION_CODE_ORDERBY_VALUE_NO_DEFINED = "orderby_no_defined";
	
	public static final String EXCEPTION_CODE_COD_TELECAREPROGRAM_VALUE_NO_DEFINED = "cod_telecareprogram_no_defined";

	public static final String EXCEPTION_CODE_COD_IDRESULTQUESTIONNAIRE_VALUE_NO_DEFINED = "idresultquestionnaire_no_defined";
	public static final String EXCEPTION_CODE_QUESTIONNAIRE_CONFIGURATION_NOT_DEFINED = "questionnaire_configuration_not_defined";
	
	public static final String EXCEPTION_CODE_QUESTIONNAIRE_CONFIGURATION_CONTEXT_BROKER_NOT_DEFINED = "questionnaire_configuration_context_broker_not_defined";
	public static final String EXCEPTION_CODE_QUESTIONNAIRE_CONFIGURATION_CONTEXT_BROKER_ENDPOINT_NOT_DEFINED = "questionnaire_configuration_context_broker_endpoint_not_defined";
	public static final String EXCEPTION_CODE_QUESTIONNAIRE_CONFIGURATION_CONTEXT_BROKER_PORT_NOT_DEFINED = "questionnaire_configuration_context_broker_port_not_defined";
	
	public static final String EXCEPTION_CODE_QUESTIONNAIRE_CONFIGURATION_EVENT_SERVICE_NOT_DEFINED = "questionnaire_configuration_event_service_not_defined";
	public static final String EXCEPTION_CODE_QUESTIONNAIRE_CONFIGURATION_EVENT_SERVICE_ENDPOINT_NOT_DEFINED = "questionnaire_configuration_event_service_endpoint_not_defined";
	public static final String EXCEPTION_CODE_QUESTIONNAIRE_CONFIGURATION_EVENT_SERVICE_TOKEN_NOT_DEFINED = "questionnaire_configuration_event_service_token_not_defined";
	
	public static String EXCEPTION_CODE_QUESTIONNAIRE_MONITORING_PLANNING_ALREADY_DONE="questionnaire_monitoring_planning_already_done";
	public static String EXCEPTION_CODE_QUESTIONNAIRE_MONITORING_PLANNING_NO_DEFINED="questionnaire_monitoring_planning_no_defined";
		
}

