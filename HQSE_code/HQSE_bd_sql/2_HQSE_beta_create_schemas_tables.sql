
--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.4
-- Dumped by pg_dump version 9.3.1
-- Started on 2015-06-19 13:07:04

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 7 (class 2615 OID 16399)
-- Name: ktek_commons; Type: SCHEMA; Schema: -; Owner: ktek_usr
--

CREATE SCHEMA ktek_commons;


ALTER SCHEMA ktek_commons OWNER TO ktek_usr;

--
-- TOC entry 8 (class 2615 OID 16400)
-- Name: ktek_general; Type: SCHEMA; Schema: -; Owner: ktek_usr
--

CREATE SCHEMA ktek_general;


ALTER SCHEMA ktek_general OWNER TO ktek_usr;

--
-- TOC entry 9 (class 2615 OID 16401)
-- Name: ktek_questionnaire; Type: SCHEMA; Schema: -; Owner: ktek_usr
--

CREATE SCHEMA ktek_questionnaire;


ALTER SCHEMA ktek_questionnaire OWNER TO ktek_usr;

--
-- TOC entry 223 (class 3079 OID 11756)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2275 (class 0 OID 0)
-- Dependencies: 223
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = ktek_commons, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 176 (class 1259 OID 17115)
-- Name: ktek_auditaccesslog; Type: TABLE; Schema: ktek_commons; Owner: ktek_usr; Tablespace: 
--

CREATE TABLE ktek_auditaccesslog (
    ktek_pk_idauditaccesslog integer NOT NULL,
    idaccessuser bigint NOT NULL,
    idaccesseduser bigint NOT NULL,
    codtelecareprogram character varying(50) NOT NULL,
    typeaction smallint NOT NULL,
    idaction integer,
    logitemcreation bigint NOT NULL
);


ALTER TABLE ktek_commons.ktek_auditaccesslog OWNER TO ktek_usr;

--
-- TOC entry 175 (class 1259 OID 17113)
-- Name: ktek_auditaccesslog_idaccesseduser_seq; Type: SEQUENCE; Schema: ktek_commons; Owner: ktek_usr
--

CREATE SEQUENCE ktek_auditaccesslog_idaccesseduser_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ktek_commons.ktek_auditaccesslog_idaccesseduser_seq OWNER TO ktek_usr;

--
-- TOC entry 2276 (class 0 OID 0)
-- Dependencies: 175
-- Name: ktek_auditaccesslog_idaccesseduser_seq; Type: SEQUENCE OWNED BY; Schema: ktek_commons; Owner: ktek_usr
--

ALTER SEQUENCE ktek_auditaccesslog_idaccesseduser_seq OWNED BY ktek_auditaccesslog.idaccesseduser;


--
-- TOC entry 174 (class 1259 OID 17111)
-- Name: ktek_auditaccesslog_idaccessuser_seq; Type: SEQUENCE; Schema: ktek_commons; Owner: ktek_usr
--

CREATE SEQUENCE ktek_auditaccesslog_idaccessuser_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ktek_commons.ktek_auditaccesslog_idaccessuser_seq OWNER TO ktek_usr;

--
-- TOC entry 2277 (class 0 OID 0)
-- Dependencies: 174
-- Name: ktek_auditaccesslog_idaccessuser_seq; Type: SEQUENCE OWNED BY; Schema: ktek_commons; Owner: ktek_usr
--

ALTER SEQUENCE ktek_auditaccesslog_idaccessuser_seq OWNED BY ktek_auditaccesslog.idaccessuser;


--
-- TOC entry 173 (class 1259 OID 17109)
-- Name: ktek_auditaccesslog_ktek_pk_idauditaccesslog_seq; Type: SEQUENCE; Schema: ktek_commons; Owner: ktek_usr
--

CREATE SEQUENCE ktek_auditaccesslog_ktek_pk_idauditaccesslog_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ktek_commons.ktek_auditaccesslog_ktek_pk_idauditaccesslog_seq OWNER TO ktek_usr;

--
-- TOC entry 2278 (class 0 OID 0)
-- Dependencies: 173
-- Name: ktek_auditaccesslog_ktek_pk_idauditaccesslog_seq; Type: SEQUENCE OWNED BY; Schema: ktek_commons; Owner: ktek_usr
--

ALTER SEQUENCE ktek_auditaccesslog_ktek_pk_idauditaccesslog_seq OWNED BY ktek_auditaccesslog.ktek_pk_idauditaccesslog;


--
-- TOC entry 180 (class 1259 OID 17133)
-- Name: ktek_language; Type: TABLE; Schema: ktek_commons; Owner: ktek_usr; Tablespace: 
--

CREATE TABLE ktek_language (
    ktek_pk_idlanguage integer NOT NULL,
    ktek_uk_codlanguage character varying(3) NOT NULL,
    deslanguage character varying(15),
    isdefault smallint NOT NULL
);


ALTER TABLE ktek_commons.ktek_language OWNER TO ktek_usr;

--
-- TOC entry 179 (class 1259 OID 17131)
-- Name: ktek_language_ktek_pk_idlanguage_seq; Type: SEQUENCE; Schema: ktek_commons; Owner: ktek_usr
--

CREATE SEQUENCE ktek_language_ktek_pk_idlanguage_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ktek_commons.ktek_language_ktek_pk_idlanguage_seq OWNER TO ktek_usr;

--
-- TOC entry 2279 (class 0 OID 0)
-- Dependencies: 179
-- Name: ktek_language_ktek_pk_idlanguage_seq; Type: SEQUENCE OWNED BY; Schema: ktek_commons; Owner: ktek_usr
--

ALTER SEQUENCE ktek_language_ktek_pk_idlanguage_seq OWNED BY ktek_language.ktek_pk_idlanguage;


--
-- TOC entry 221 (class 1259 OID 17326)
-- Name: ktek_pathology; Type: TABLE; Schema: ktek_commons; Owner: ktek_usr; Tablespace: 
--

CREATE TABLE ktek_pathology (
    ktek_pk_idpathology integer NOT NULL,
    ktek_uk_codpathology character varying(50) NOT NULL,
    namepathology character varying(50) NOT NULL,
    despathology character varying(255)
);


ALTER TABLE ktek_commons.ktek_pathology OWNER TO ktek_usr;

--
-- TOC entry 220 (class 1259 OID 17324)
-- Name: ktek_pathology_ktek_pk_idpathology_seq; Type: SEQUENCE; Schema: ktek_commons; Owner: ktek_usr
--

CREATE SEQUENCE ktek_pathology_ktek_pk_idpathology_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ktek_commons.ktek_pathology_ktek_pk_idpathology_seq OWNER TO ktek_usr;

--
-- TOC entry 2280 (class 0 OID 0)
-- Dependencies: 220
-- Name: ktek_pathology_ktek_pk_idpathology_seq; Type: SEQUENCE OWNED BY; Schema: ktek_commons; Owner: ktek_usr
--

ALTER SEQUENCE ktek_pathology_ktek_pk_idpathology_seq OWNED BY ktek_pathology.ktek_pk_idpathology;


--
-- TOC entry 185 (class 1259 OID 17151)
-- Name: ktek_tpsettings; Type: TABLE; Schema: ktek_commons; Owner: ktek_usr; Tablespace: 
--

CREATE TABLE ktek_tpsettings (
    ktek_fk_iduser bigint NOT NULL,
    ktek_fk_idlanguage bigint NOT NULL,
    typecomchannel smallint NOT NULL
);


ALTER TABLE ktek_commons.ktek_tpsettings OWNER TO ktek_usr;

--
-- TOC entry 184 (class 1259 OID 17149)
-- Name: ktek_tpsettings_ktek_fk_idlanguage_seq; Type: SEQUENCE; Schema: ktek_commons; Owner: ktek_usr
--

CREATE SEQUENCE ktek_tpsettings_ktek_fk_idlanguage_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ktek_commons.ktek_tpsettings_ktek_fk_idlanguage_seq OWNER TO ktek_usr;

--
-- TOC entry 2281 (class 0 OID 0)
-- Dependencies: 184
-- Name: ktek_tpsettings_ktek_fk_idlanguage_seq; Type: SEQUENCE OWNED BY; Schema: ktek_commons; Owner: ktek_usr
--

ALTER SEQUENCE ktek_tpsettings_ktek_fk_idlanguage_seq OWNED BY ktek_tpsettings.ktek_fk_idlanguage;


--
-- TOC entry 183 (class 1259 OID 17147)
-- Name: ktek_tpsettings_ktek_fk_iduser_seq; Type: SEQUENCE; Schema: ktek_commons; Owner: ktek_usr
--

CREATE SEQUENCE ktek_tpsettings_ktek_fk_iduser_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ktek_commons.ktek_tpsettings_ktek_fk_iduser_seq OWNER TO ktek_usr;

--
-- TOC entry 2282 (class 0 OID 0)
-- Dependencies: 183
-- Name: ktek_tpsettings_ktek_fk_iduser_seq; Type: SEQUENCE OWNED BY; Schema: ktek_commons; Owner: ktek_usr
--

ALTER SEQUENCE ktek_tpsettings_ktek_fk_iduser_seq OWNED BY ktek_tpsettings.ktek_fk_iduser;


--
-- TOC entry 190 (class 1259 OID 17170)
-- Name: ktek_translation_text; Type: TABLE; Schema: ktek_commons; Owner: ktek_usr; Tablespace: 
--

CREATE TABLE ktek_translation_text (
    ktek_pk_translation_text integer NOT NULL,
    ktek_idregister bigint NOT NULL,
    ktek_keycolum character varying(255) NOT NULL,
    ktek_fk_language bigint NOT NULL,
    ktek_columvalue text NOT NULL
);


ALTER TABLE ktek_commons.ktek_translation_text OWNER TO ktek_usr;

--
-- TOC entry 189 (class 1259 OID 17168)
-- Name: ktek_translation_text_ktek_fk_language_seq; Type: SEQUENCE; Schema: ktek_commons; Owner: ktek_usr
--

CREATE SEQUENCE ktek_translation_text_ktek_fk_language_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ktek_commons.ktek_translation_text_ktek_fk_language_seq OWNER TO ktek_usr;

--
-- TOC entry 2283 (class 0 OID 0)
-- Dependencies: 189
-- Name: ktek_translation_text_ktek_fk_language_seq; Type: SEQUENCE OWNED BY; Schema: ktek_commons; Owner: ktek_usr
--

ALTER SEQUENCE ktek_translation_text_ktek_fk_language_seq OWNED BY ktek_translation_text.ktek_fk_language;


--
-- TOC entry 188 (class 1259 OID 17166)
-- Name: ktek_translation_text_ktek_pk_translation_text_seq; Type: SEQUENCE; Schema: ktek_commons; Owner: ktek_usr
--

CREATE SEQUENCE ktek_translation_text_ktek_pk_translation_text_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ktek_commons.ktek_translation_text_ktek_pk_translation_text_seq OWNER TO ktek_usr;

--
-- TOC entry 2284 (class 0 OID 0)
-- Dependencies: 188
-- Name: ktek_translation_text_ktek_pk_translation_text_seq; Type: SEQUENCE OWNED BY; Schema: ktek_commons; Owner: ktek_usr
--

ALTER SEQUENCE ktek_translation_text_ktek_pk_translation_text_seq OWNED BY ktek_translation_text.ktek_pk_translation_text;


--
-- TOC entry 178 (class 1259 OID 17125)
-- Name: ktek_user; Type: TABLE; Schema: ktek_commons; Owner: ktek_usr; Tablespace: 
--

CREATE TABLE ktek_user (
    ktek_pk_iduser integer NOT NULL,
    ktek_uk_coduser character varying(255) NOT NULL
);


ALTER TABLE ktek_commons.ktek_user OWNER TO ktek_usr;

--
-- TOC entry 187 (class 1259 OID 17160)
-- Name: ktek_user_ext; Type: TABLE; Schema: ktek_commons; Owner: ktek_usr; Tablespace: 
--

CREATE TABLE ktek_user_ext (
    ktek_fk_iduser bigint NOT NULL,
    ktek_uk_coduserid character varying(50) NOT NULL,
    email character varying(50),
    mobile character varying(15),
    keyuser character varying(30),
    passworduser character varying(30),
    name character varying(50),
    surname character varying(255)
);


ALTER TABLE ktek_commons.ktek_user_ext OWNER TO ktek_usr;

--
-- TOC entry 186 (class 1259 OID 17158)
-- Name: ktek_user_ext_ktek_fk_iduser_seq; Type: SEQUENCE; Schema: ktek_commons; Owner: ktek_usr
--

CREATE SEQUENCE ktek_user_ext_ktek_fk_iduser_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ktek_commons.ktek_user_ext_ktek_fk_iduser_seq OWNER TO ktek_usr;

--
-- TOC entry 2285 (class 0 OID 0)
-- Dependencies: 186
-- Name: ktek_user_ext_ktek_fk_iduser_seq; Type: SEQUENCE OWNED BY; Schema: ktek_commons; Owner: ktek_usr
--

ALTER SEQUENCE ktek_user_ext_ktek_fk_iduser_seq OWNED BY ktek_user_ext.ktek_fk_iduser;


--
-- TOC entry 177 (class 1259 OID 17123)
-- Name: ktek_user_ktek_pk_iduser_seq; Type: SEQUENCE; Schema: ktek_commons; Owner: ktek_usr
--

CREATE SEQUENCE ktek_user_ktek_pk_iduser_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ktek_commons.ktek_user_ktek_pk_iduser_seq OWNER TO ktek_usr;

--
-- TOC entry 2286 (class 0 OID 0)
-- Dependencies: 177
-- Name: ktek_user_ktek_pk_iduser_seq; Type: SEQUENCE OWNED BY; Schema: ktek_commons; Owner: ktek_usr
--

ALTER SEQUENCE ktek_user_ktek_pk_iduser_seq OWNED BY ktek_user.ktek_pk_iduser;


--
-- TOC entry 182 (class 1259 OID 17141)
-- Name: ktek_usersessiondata; Type: TABLE; Schema: ktek_commons; Owner: ktek_usr; Tablespace: 
--

CREATE TABLE ktek_usersessiondata (
    ktek_fk_iduser bigint NOT NULL,
    sessiontoken character varying(255) NOT NULL,
    dataexpiration bigint NOT NULL
);


ALTER TABLE ktek_commons.ktek_usersessiondata OWNER TO ktek_usr;

--
-- TOC entry 181 (class 1259 OID 17139)
-- Name: ktek_usersessiondata_ktek_fk_iduser_seq; Type: SEQUENCE; Schema: ktek_commons; Owner: ktek_usr
--

CREATE SEQUENCE ktek_usersessiondata_ktek_fk_iduser_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ktek_commons.ktek_usersessiondata_ktek_fk_iduser_seq OWNER TO ktek_usr;

--
-- TOC entry 2287 (class 0 OID 0)
-- Dependencies: 181
-- Name: ktek_usersessiondata_ktek_fk_iduser_seq; Type: SEQUENCE OWNED BY; Schema: ktek_commons; Owner: ktek_usr
--

ALTER SEQUENCE ktek_usersessiondata_ktek_fk_iduser_seq OWNED BY ktek_usersessiondata.ktek_fk_iduser;


SET search_path = ktek_questionnaire, pg_catalog;

--
-- TOC entry 204 (class 1259 OID 17248)
-- Name: ktek_answer; Type: TABLE; Schema: ktek_questionnaire; Owner: ktek_usr; Tablespace: 
--

CREATE TABLE ktek_answer (
    ktek_pk_idanswer integer NOT NULL,
    ktek_fk_idquestionnaireitem integer,
    ktek_uk_codanswer character varying(50) NOT NULL,
    nameanswer character varying(255) NOT NULL,
    desanswer character varying(255),
    imageanswer character varying(50),
    scoreanswer smallint NOT NULL
);


ALTER TABLE ktek_questionnaire.ktek_answer OWNER TO ktek_usr;

--
-- TOC entry 203 (class 1259 OID 17243)
-- Name: ktek_answerset; Type: TABLE; Schema: ktek_questionnaire; Owner: ktek_usr; Tablespace: 
--

CREATE TABLE ktek_answerset (
    ktek_pk_idanswerset integer NOT NULL,
    codanswersetl character varying(50),
    nameanswerset character varying(50) NOT NULL
);


ALTER TABLE ktek_questionnaire.ktek_answerset OWNER TO ktek_usr;

--
-- TOC entry 210 (class 1259 OID 17277)
-- Name: ktek_answerset_answer; Type: TABLE; Schema: ktek_questionnaire; Owner: ktek_usr; Tablespace: 
--

CREATE TABLE ktek_answerset_answer (
    ktek_fk_idanswerset integer NOT NULL,
    ktek_fk_idanswer integer NOT NULL
);


ALTER TABLE ktek_questionnaire.ktek_answerset_answer OWNER TO ktek_usr;

--
-- TOC entry 209 (class 1259 OID 17271)
-- Name: ktek_codification; Type: TABLE; Schema: ktek_questionnaire; Owner: ktek_usr; Tablespace: 
--

CREATE TABLE ktek_codification (
    ktek_pk_idcodification integer NOT NULL,
    codcodification character varying(25) NOT NULL,
    descodification character varying(255)
);


ALTER TABLE ktek_questionnaire.ktek_codification OWNER TO ktek_usr;

--
-- TOC entry 208 (class 1259 OID 17269)
-- Name: ktek_codification_ktek_pk_idcodification_seq; Type: SEQUENCE; Schema: ktek_questionnaire; Owner: ktek_usr
--

CREATE SEQUENCE ktek_codification_ktek_pk_idcodification_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ktek_questionnaire.ktek_codification_ktek_pk_idcodification_seq OWNER TO ktek_usr;

--
-- TOC entry 2288 (class 0 OID 0)
-- Dependencies: 208
-- Name: ktek_codification_ktek_pk_idcodification_seq; Type: SEQUENCE OWNED BY; Schema: ktek_questionnaire; Owner: ktek_usr
--

ALTER SEQUENCE ktek_codification_ktek_pk_idcodification_seq OWNED BY ktek_codification.ktek_pk_idcodification;


--
-- TOC entry 217 (class 1259 OID 17310)
-- Name: ktek_formatquestionnaire; Type: TABLE; Schema: ktek_questionnaire; Owner: ktek_usr; Tablespace: 
--

CREATE TABLE ktek_formatquestionnaire (
    ktek_pk_idformatquestionnaire integer NOT NULL,
    ktek_fk_questionnaire integer NOT NULL,
    formatpagination smallint NOT NULL,
    formatintegerparameter smallint NOT NULL,
    formatdecimalparameter smallint NOT NULL,
    formatsetuniqueitem smallint NOT NULL,
    formatsetmultitem smallint NOT NULL
);


ALTER TABLE ktek_questionnaire.ktek_formatquestionnaire OWNER TO ktek_usr;

--
-- TOC entry 216 (class 1259 OID 17308)
-- Name: ktek_formatquestionnaire_ktek_pk_idformatquestionnaire_seq; Type: SEQUENCE; Schema: ktek_questionnaire; Owner: ktek_usr
--

CREATE SEQUENCE ktek_formatquestionnaire_ktek_pk_idformatquestionnaire_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ktek_questionnaire.ktek_formatquestionnaire_ktek_pk_idformatquestionnaire_seq OWNER TO ktek_usr;

--
-- TOC entry 2289 (class 0 OID 0)
-- Dependencies: 216
-- Name: ktek_formatquestionnaire_ktek_pk_idformatquestionnaire_seq; Type: SEQUENCE OWNED BY; Schema: ktek_questionnaire; Owner: ktek_usr
--

ALTER SEQUENCE ktek_formatquestionnaire_ktek_pk_idformatquestionnaire_seq OWNED BY ktek_formatquestionnaire.ktek_pk_idformatquestionnaire;


--
-- TOC entry 212 (class 1259 OID 17287)
-- Name: ktek_parameter; Type: TABLE; Schema: ktek_questionnaire; Owner: ktek_usr; Tablespace: 
--

CREATE TABLE ktek_parameter (
    ktek_fk_idquestionnaireitem integer NOT NULL,
    typeparameter smallint NOT NULL,
    typedatacapture smallint NOT NULL,
    valuedefault real,
    valuemin real NOT NULL,
    valuemax real NOT NULL
);


ALTER TABLE ktek_questionnaire.ktek_parameter OWNER TO ktek_usr;

--
-- TOC entry 213 (class 1259 OID 17292)
-- Name: ktek_qitem_section; Type: TABLE; Schema: ktek_questionnaire; Owner: ktek_usr; Tablespace: 
--

CREATE TABLE ktek_qitem_section (
    ktek_fk_idquestionnairesection integer NOT NULL,
    ktek_fk_idquestionnaireitem integer NOT NULL,
    sortorder smallint NOT NULL
);


ALTER TABLE ktek_questionnaire.ktek_qitem_section OWNER TO ktek_usr;

--
-- TOC entry 214 (class 1259 OID 17297)
-- Name: ktek_qsection_questionnaire; Type: TABLE; Schema: ktek_questionnaire; Owner: ktek_usr; Tablespace: 
--

CREATE TABLE ktek_qsection_questionnaire (
    ktek_fk_idquestionnaire integer NOT NULL,
    ktek_fk_idquestionnairesection integer NOT NULL,
    sortorder smallint NOT NULL
);


ALTER TABLE ktek_questionnaire.ktek_qsection_questionnaire OWNER TO ktek_usr;

--
-- TOC entry 215 (class 1259 OID 17302)
-- Name: ktek_question; Type: TABLE; Schema: ktek_questionnaire; Owner: ktek_usr; Tablespace: 
--

CREATE TABLE ktek_question (
    ktek_fk_idquestionnaireitem integer NOT NULL,
    typeanswersortorder smallint NOT NULL,
    typeanswer smallint NOT NULL,
    formatanswerunique smallint,
    ktek_fk_idanswerset integer,
    weightquestion smallint DEFAULT 1 NOT NULL
);


ALTER TABLE ktek_questionnaire.ktek_question OWNER TO ktek_usr;

--
-- TOC entry 191 (class 1259 OID 17180)
-- Name: ktek_questionnaire; Type: TABLE; Schema: ktek_questionnaire; Owner: ktek_usr; Tablespace: 
--

CREATE TABLE ktek_questionnaire (
    ktek_pk_idquestionnaire integer NOT NULL,
    idpathology character varying(50),
    ktek_uk_codquestionnaire character varying(25) NOT NULL,
    namequestionnaire character varying(255) NOT NULL,
    desquestionnaire character varying(255),
    desinstructionsquestionnaire text NOT NULL,
    desevaluation text,
    ismultisection smallint NOT NULL,
    typequestionnaire smallint NOT NULL,
    typesortorder smallint NOT NULL,
    typequestionnaireflow smallint NOT NULL,
    datevalidfrom bigint NOT NULL,
    datevalidto bigint,
    datecreation bigint NOT NULL,
    typemonitoringactivity smallint DEFAULT 0,
    periodicityunit smallint,
    periodictyvalue smallint,
    collectiontimefrom bigint,
    collectiontimeto bigint,
    completionintervalunit smallint,
    completionintervalvalue smallint,
    isdeleted smallint NOT NULL
);


ALTER TABLE ktek_questionnaire.ktek_questionnaire OWNER TO ktek_usr;

--
-- TOC entry 222 (class 1259 OID 17334)
-- Name: ktek_questionnaireconfiguration; Type: TABLE; Schema: ktek_questionnaire; Owner: ktek_usr; Tablespace: 
--

CREATE TABLE ktek_questionnaireconfiguration (
    ktek_pk_ktek_idquestionnaireconfiguration integer NOT NULL,
    ktek_typesave integer NOT NULL,
    endpointserver character varying(255),
    eventserviceoauth2headertoken character varying(255),
    timeout integer,
    port integer
);


ALTER TABLE ktek_questionnaire.ktek_questionnaireconfiguration OWNER TO ktek_usr;

--
-- TOC entry 195 (class 1259 OID 17205)
-- Name: ktek_questionnaireitem; Type: TABLE; Schema: ktek_questionnaire; Owner: ktek_usr; Tablespace: 
--

CREATE TABLE ktek_questionnaireitem (
    ktek_pk_idquestionnaireitem integer NOT NULL,
    ktek_uk_codquestionnaireitem character varying(50) NOT NULL,
    namequestionnaireitem character varying(255) NOT NULL,
    desquestionnaireitem character varying(255),
    typequestionnaireitem smallint NOT NULL,
    isrequired smallint NOT NULL,
    isdeleted smallint NOT NULL
);


ALTER TABLE ktek_questionnaire.ktek_questionnaireitem OWNER TO ktek_usr;

--
-- TOC entry 207 (class 1259 OID 17263)
-- Name: ktek_questionnaireitem_codification; Type: TABLE; Schema: ktek_questionnaire; Owner: ktek_usr; Tablespace: 
--

CREATE TABLE ktek_questionnaireitem_codification (
    ktek_fk_idquestionnaireitem integer NOT NULL,
    ktek_fk_idcodification bigint NOT NULL,
    codquestionnaireitem character varying(255) NOT NULL
);


ALTER TABLE ktek_questionnaire.ktek_questionnaireitem_codification OWNER TO ktek_usr;

--
-- TOC entry 206 (class 1259 OID 17261)
-- Name: ktek_questionnaireitem_codification_ktek_fk_idcodification_seq; Type: SEQUENCE; Schema: ktek_questionnaire; Owner: ktek_usr
--

CREATE SEQUENCE ktek_questionnaireitem_codification_ktek_fk_idcodification_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ktek_questionnaire.ktek_questionnaireitem_codification_ktek_fk_idcodification_seq OWNER TO ktek_usr;

--
-- TOC entry 2290 (class 0 OID 0)
-- Dependencies: 206
-- Name: ktek_questionnaireitem_codification_ktek_fk_idcodification_seq; Type: SEQUENCE OWNED BY; Schema: ktek_questionnaire; Owner: ktek_usr
--

ALTER SEQUENCE ktek_questionnaireitem_codification_ktek_fk_idcodification_seq OWNED BY ktek_questionnaireitem_codification.ktek_fk_idcodification;


--
-- TOC entry 199 (class 1259 OID 17224)
-- Name: ktek_questionnairesection; Type: TABLE; Schema: ktek_questionnaire; Owner: ktek_usr; Tablespace: 
--

CREATE TABLE ktek_questionnairesection (
    ktek_pk_idquestionnairesection integer NOT NULL,
    namequestionnairesection character varying(255),
    desquestionnairesection character varying(255),
    desquestionnairesectioninstructions text
);


ALTER TABLE ktek_questionnaire.ktek_questionnairesection OWNER TO ktek_usr;

--
-- TOC entry 202 (class 1259 OID 17236)
-- Name: ktek_result_questionnaire; Type: TABLE; Schema: ktek_questionnaire; Owner: ktek_usr; Tablespace: 
--

CREATE TABLE ktek_result_questionnaire (
    ktek_pk_idresultquestionnaire integer NOT NULL,
    codtelecareprogram character varying(50) NOT NULL,
    coduserid character varying(50) NOT NULL,
    ktek_fk_idquestionnaire integer,
    ktek_fk_iduserquestionnaireplanning bigint,
    evaluationscorequestionnaire smallint NOT NULL,
    resultcreation bigint NOT NULL
);


ALTER TABLE ktek_questionnaire.ktek_result_questionnaire OWNER TO ktek_usr;

--
-- TOC entry 201 (class 1259 OID 17234)
-- Name: ktek_result_questionnaire_ktek_fk_iduserquestionnaireplanni_seq; Type: SEQUENCE; Schema: ktek_questionnaire; Owner: ktek_usr
--

CREATE SEQUENCE ktek_result_questionnaire_ktek_fk_iduserquestionnaireplanni_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ktek_questionnaire.ktek_result_questionnaire_ktek_fk_iduserquestionnaireplanni_seq OWNER TO ktek_usr;

--
-- TOC entry 2291 (class 0 OID 0)
-- Dependencies: 201
-- Name: ktek_result_questionnaire_ktek_fk_iduserquestionnaireplanni_seq; Type: SEQUENCE OWNED BY; Schema: ktek_questionnaire; Owner: ktek_usr
--

ALTER SEQUENCE ktek_result_questionnaire_ktek_fk_iduserquestionnaireplanni_seq OWNED BY ktek_result_questionnaire.ktek_fk_iduserquestionnaireplanning;


--
-- TOC entry 200 (class 1259 OID 17232)
-- Name: ktek_result_questionnaire_ktek_pk_idresultquestionnaire_seq; Type: SEQUENCE; Schema: ktek_questionnaire; Owner: ktek_usr
--

CREATE SEQUENCE ktek_result_questionnaire_ktek_pk_idresultquestionnaire_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ktek_questionnaire.ktek_result_questionnaire_ktek_pk_idresultquestionnaire_seq OWNER TO ktek_usr;

--
-- TOC entry 2292 (class 0 OID 0)
-- Dependencies: 200
-- Name: ktek_result_questionnaire_ktek_pk_idresultquestionnaire_seq; Type: SEQUENCE OWNED BY; Schema: ktek_questionnaire; Owner: ktek_usr
--

ALTER SEQUENCE ktek_result_questionnaire_ktek_pk_idresultquestionnaire_seq OWNED BY ktek_result_questionnaire.ktek_pk_idresultquestionnaire;


--
-- TOC entry 194 (class 1259 OID 17195)
-- Name: ktek_result_questionnaireitem; Type: TABLE; Schema: ktek_questionnaire; Owner: ktek_usr; Tablespace: 
--

CREATE TABLE ktek_result_questionnaireitem (
    ktek_pk_idresultquestionnaireitem integer NOT NULL,
    ktek_fk_idquestionnaireitem integer NOT NULL,
    ktek_fk_idresultquestionnairesection bigint NOT NULL,
    typeresult smallint NOT NULL,
    integervalue bigint,
    decimalvalue real,
    stringvalue character varying(255),
    textvalue text,
    codanswer character varying(50),
    scoreanswer smallint
);


ALTER TABLE ktek_questionnaire.ktek_result_questionnaireitem OWNER TO ktek_usr;

--
-- TOC entry 193 (class 1259 OID 17193)
-- Name: ktek_result_questionnaireitem_ktek_fk_idresultquestionnaire_seq; Type: SEQUENCE; Schema: ktek_questionnaire; Owner: ktek_usr
--

CREATE SEQUENCE ktek_result_questionnaireitem_ktek_fk_idresultquestionnaire_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ktek_questionnaire.ktek_result_questionnaireitem_ktek_fk_idresultquestionnaire_seq OWNER TO ktek_usr;

--
-- TOC entry 2293 (class 0 OID 0)
-- Dependencies: 193
-- Name: ktek_result_questionnaireitem_ktek_fk_idresultquestionnaire_seq; Type: SEQUENCE OWNED BY; Schema: ktek_questionnaire; Owner: ktek_usr
--

ALTER SEQUENCE ktek_result_questionnaireitem_ktek_fk_idresultquestionnaire_seq OWNED BY ktek_result_questionnaireitem.ktek_fk_idresultquestionnairesection;


--
-- TOC entry 192 (class 1259 OID 17191)
-- Name: ktek_result_questionnaireitem_ktek_pk_idresultquestionnaire_seq; Type: SEQUENCE; Schema: ktek_questionnaire; Owner: ktek_usr
--

CREATE SEQUENCE ktek_result_questionnaireitem_ktek_pk_idresultquestionnaire_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ktek_questionnaire.ktek_result_questionnaireitem_ktek_pk_idresultquestionnaire_seq OWNER TO ktek_usr;

--
-- TOC entry 2294 (class 0 OID 0)
-- Dependencies: 192
-- Name: ktek_result_questionnaireitem_ktek_pk_idresultquestionnaire_seq; Type: SEQUENCE OWNED BY; Schema: ktek_questionnaire; Owner: ktek_usr
--

ALTER SEQUENCE ktek_result_questionnaireitem_ktek_pk_idresultquestionnaire_seq OWNED BY ktek_result_questionnaireitem.ktek_pk_idresultquestionnaireitem;


--
-- TOC entry 198 (class 1259 OID 17217)
-- Name: ktek_result_questionnairesection; Type: TABLE; Schema: ktek_questionnaire; Owner: ktek_usr; Tablespace: 
--

CREATE TABLE ktek_result_questionnairesection (
    ktek_pk_idresultquestionnairesection integer NOT NULL,
    ktek_fk_idquestionnairesection integer NOT NULL,
    ktek_fk_idresultquestionnaire bigint NOT NULL,
    evaluationscorequestionnairesection smallint NOT NULL
);


ALTER TABLE ktek_questionnaire.ktek_result_questionnairesection OWNER TO ktek_usr;

--
-- TOC entry 197 (class 1259 OID 17215)
-- Name: ktek_result_questionnairesect_ktek_fk_idresultquestionnaire_seq; Type: SEQUENCE; Schema: ktek_questionnaire; Owner: ktek_usr
--

CREATE SEQUENCE ktek_result_questionnairesect_ktek_fk_idresultquestionnaire_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ktek_questionnaire.ktek_result_questionnairesect_ktek_fk_idresultquestionnaire_seq OWNER TO ktek_usr;

--
-- TOC entry 2295 (class 0 OID 0)
-- Dependencies: 197
-- Name: ktek_result_questionnairesect_ktek_fk_idresultquestionnaire_seq; Type: SEQUENCE OWNED BY; Schema: ktek_questionnaire; Owner: ktek_usr
--

ALTER SEQUENCE ktek_result_questionnairesect_ktek_fk_idresultquestionnaire_seq OWNED BY ktek_result_questionnairesection.ktek_fk_idresultquestionnaire;


--
-- TOC entry 196 (class 1259 OID 17213)
-- Name: ktek_result_questionnairesect_ktek_pk_idresultquestionnaire_seq; Type: SEQUENCE; Schema: ktek_questionnaire; Owner: ktek_usr
--

CREATE SEQUENCE ktek_result_questionnairesect_ktek_pk_idresultquestionnaire_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ktek_questionnaire.ktek_result_questionnairesect_ktek_pk_idresultquestionnaire_seq OWNER TO ktek_usr;

--
-- TOC entry 2296 (class 0 OID 0)
-- Dependencies: 196
-- Name: ktek_result_questionnairesect_ktek_pk_idresultquestionnaire_seq; Type: SEQUENCE OWNED BY; Schema: ktek_questionnaire; Owner: ktek_usr
--

ALTER SEQUENCE ktek_result_questionnairesect_ktek_pk_idresultquestionnaire_seq OWNED BY ktek_result_questionnairesection.ktek_pk_idresultquestionnairesection;


--
-- TOC entry 205 (class 1259 OID 17256)
-- Name: ktek_unit; Type: TABLE; Schema: ktek_questionnaire; Owner: ktek_usr; Tablespace: 
--

CREATE TABLE ktek_unit (
    ktek_pk_idunit integer NOT NULL,
    ktek_uk_codunit character varying(50) NOT NULL
);


ALTER TABLE ktek_questionnaire.ktek_unit OWNER TO ktek_usr;

--
-- TOC entry 211 (class 1259 OID 17282)
-- Name: ktek_unit_parameter; Type: TABLE; Schema: ktek_questionnaire; Owner: ktek_usr; Tablespace: 
--

CREATE TABLE ktek_unit_parameter (
    ktek_fk_idquestionnaireitem integer NOT NULL,
    ktek_fk_idunit integer NOT NULL,
    valueconversion real NOT NULL,
    isdefault smallint NOT NULL
);


ALTER TABLE ktek_questionnaire.ktek_unit_parameter OWNER TO ktek_usr;

--
-- TOC entry 219 (class 1259 OID 17318)
-- Name: ktek_userquestionnaire_planning; Type: TABLE; Schema: ktek_questionnaire; Owner: ktek_usr; Tablespace: 
--

CREATE TABLE ktek_userquestionnaire_planning (
    ktek_pk_iduserquestionnaireplanning integer NOT NULL,
    ktek_fk_idquestionnaire integer NOT NULL,
    coduser character varying(50) NOT NULL,
    codtelecareprogram character varying(50) NOT NULL,
    plannedfrom bigint NOT NULL,
    plannedto bigint NOT NULL,
    statusquestionnaire smallint NOT NULL
);


ALTER TABLE ktek_questionnaire.ktek_userquestionnaire_planning OWNER TO ktek_usr;

--
-- TOC entry 218 (class 1259 OID 17316)
-- Name: ktek_userquestionnaire_planni_ktek_pk_iduserquestionnairepl_seq; Type: SEQUENCE; Schema: ktek_questionnaire; Owner: ktek_usr
--

CREATE SEQUENCE ktek_userquestionnaire_planni_ktek_pk_iduserquestionnairepl_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ktek_questionnaire.ktek_userquestionnaire_planni_ktek_pk_iduserquestionnairepl_seq OWNER TO ktek_usr;

--
-- TOC entry 2297 (class 0 OID 0)
-- Dependencies: 218
-- Name: ktek_userquestionnaire_planni_ktek_pk_iduserquestionnairepl_seq; Type: SEQUENCE OWNED BY; Schema: ktek_questionnaire; Owner: ktek_usr
--

ALTER SEQUENCE ktek_userquestionnaire_planni_ktek_pk_iduserquestionnairepl_seq OWNED BY ktek_userquestionnaire_planning.ktek_pk_iduserquestionnaireplanning;


SET search_path = ktek_commons, pg_catalog;

--
-- TOC entry 1987 (class 2604 OID 17118)
-- Name: ktek_pk_idauditaccesslog; Type: DEFAULT; Schema: ktek_commons; Owner: ktek_usr
--

ALTER TABLE ONLY ktek_auditaccesslog ALTER COLUMN ktek_pk_idauditaccesslog SET DEFAULT nextval('ktek_auditaccesslog_ktek_pk_idauditaccesslog_seq'::regclass);


--
-- TOC entry 1988 (class 2604 OID 17119)
-- Name: idaccessuser; Type: DEFAULT; Schema: ktek_commons; Owner: ktek_usr
--

ALTER TABLE ONLY ktek_auditaccesslog ALTER COLUMN idaccessuser SET DEFAULT nextval('ktek_auditaccesslog_idaccessuser_seq'::regclass);


--
-- TOC entry 1989 (class 2604 OID 17120)
-- Name: idaccesseduser; Type: DEFAULT; Schema: ktek_commons; Owner: ktek_usr
--

ALTER TABLE ONLY ktek_auditaccesslog ALTER COLUMN idaccesseduser SET DEFAULT nextval('ktek_auditaccesslog_idaccesseduser_seq'::regclass);


--
-- TOC entry 1991 (class 2604 OID 17136)
-- Name: ktek_pk_idlanguage; Type: DEFAULT; Schema: ktek_commons; Owner: ktek_usr
--

ALTER TABLE ONLY ktek_language ALTER COLUMN ktek_pk_idlanguage SET DEFAULT nextval('ktek_language_ktek_pk_idlanguage_seq'::regclass);


--
-- TOC entry 2010 (class 2604 OID 17329)
-- Name: ktek_pk_idpathology; Type: DEFAULT; Schema: ktek_commons; Owner: ktek_usr
--

ALTER TABLE ONLY ktek_pathology ALTER COLUMN ktek_pk_idpathology SET DEFAULT nextval('ktek_pathology_ktek_pk_idpathology_seq'::regclass);


--
-- TOC entry 1993 (class 2604 OID 17154)
-- Name: ktek_fk_iduser; Type: DEFAULT; Schema: ktek_commons; Owner: ktek_usr
--

ALTER TABLE ONLY ktek_tpsettings ALTER COLUMN ktek_fk_iduser SET DEFAULT nextval('ktek_tpsettings_ktek_fk_iduser_seq'::regclass);


--
-- TOC entry 1994 (class 2604 OID 17155)
-- Name: ktek_fk_idlanguage; Type: DEFAULT; Schema: ktek_commons; Owner: ktek_usr
--

ALTER TABLE ONLY ktek_tpsettings ALTER COLUMN ktek_fk_idlanguage SET DEFAULT nextval('ktek_tpsettings_ktek_fk_idlanguage_seq'::regclass);


--
-- TOC entry 1996 (class 2604 OID 17173)
-- Name: ktek_pk_translation_text; Type: DEFAULT; Schema: ktek_commons; Owner: ktek_usr
--

ALTER TABLE ONLY ktek_translation_text ALTER COLUMN ktek_pk_translation_text SET DEFAULT nextval('ktek_translation_text_ktek_pk_translation_text_seq'::regclass);


--
-- TOC entry 1997 (class 2604 OID 17174)
-- Name: ktek_fk_language; Type: DEFAULT; Schema: ktek_commons; Owner: ktek_usr
--

ALTER TABLE ONLY ktek_translation_text ALTER COLUMN ktek_fk_language SET DEFAULT nextval('ktek_translation_text_ktek_fk_language_seq'::regclass);


--
-- TOC entry 1990 (class 2604 OID 17128)
-- Name: ktek_pk_iduser; Type: DEFAULT; Schema: ktek_commons; Owner: ktek_usr
--

ALTER TABLE ONLY ktek_user ALTER COLUMN ktek_pk_iduser SET DEFAULT nextval('ktek_user_ktek_pk_iduser_seq'::regclass);


--
-- TOC entry 1995 (class 2604 OID 17163)
-- Name: ktek_fk_iduser; Type: DEFAULT; Schema: ktek_commons; Owner: ktek_usr
--

ALTER TABLE ONLY ktek_user_ext ALTER COLUMN ktek_fk_iduser SET DEFAULT nextval('ktek_user_ext_ktek_fk_iduser_seq'::regclass);


--
-- TOC entry 1992 (class 2604 OID 17144)
-- Name: ktek_fk_iduser; Type: DEFAULT; Schema: ktek_commons; Owner: ktek_usr
--

ALTER TABLE ONLY ktek_usersessiondata ALTER COLUMN ktek_fk_iduser SET DEFAULT nextval('ktek_usersessiondata_ktek_fk_iduser_seq'::regclass);


SET search_path = ktek_questionnaire, pg_catalog;

--
-- TOC entry 2006 (class 2604 OID 17274)
-- Name: ktek_pk_idcodification; Type: DEFAULT; Schema: ktek_questionnaire; Owner: ktek_usr
--

ALTER TABLE ONLY ktek_codification ALTER COLUMN ktek_pk_idcodification SET DEFAULT nextval('ktek_codification_ktek_pk_idcodification_seq'::regclass);


--
-- TOC entry 2008 (class 2604 OID 17313)
-- Name: ktek_pk_idformatquestionnaire; Type: DEFAULT; Schema: ktek_questionnaire; Owner: ktek_usr
--

ALTER TABLE ONLY ktek_formatquestionnaire ALTER COLUMN ktek_pk_idformatquestionnaire SET DEFAULT nextval('ktek_formatquestionnaire_ktek_pk_idformatquestionnaire_seq'::regclass);


--
-- TOC entry 2005 (class 2604 OID 17266)
-- Name: ktek_fk_idcodification; Type: DEFAULT; Schema: ktek_questionnaire; Owner: ktek_usr
--

ALTER TABLE ONLY ktek_questionnaireitem_codification ALTER COLUMN ktek_fk_idcodification SET DEFAULT nextval('ktek_questionnaireitem_codification_ktek_fk_idcodification_seq'::regclass);


--
-- TOC entry 2003 (class 2604 OID 17239)
-- Name: ktek_pk_idresultquestionnaire; Type: DEFAULT; Schema: ktek_questionnaire; Owner: ktek_usr
--

ALTER TABLE ONLY ktek_result_questionnaire ALTER COLUMN ktek_pk_idresultquestionnaire SET DEFAULT nextval('ktek_result_questionnaire_ktek_pk_idresultquestionnaire_seq'::regclass);


--
-- TOC entry 2004 (class 2604 OID 17240)
-- Name: ktek_fk_iduserquestionnaireplanning; Type: DEFAULT; Schema: ktek_questionnaire; Owner: ktek_usr
--

ALTER TABLE ONLY ktek_result_questionnaire ALTER COLUMN ktek_fk_iduserquestionnaireplanning SET DEFAULT nextval('ktek_result_questionnaire_ktek_fk_iduserquestionnaireplanni_seq'::regclass);


--
-- TOC entry 1999 (class 2604 OID 17198)
-- Name: ktek_pk_idresultquestionnaireitem; Type: DEFAULT; Schema: ktek_questionnaire; Owner: ktek_usr
--

ALTER TABLE ONLY ktek_result_questionnaireitem ALTER COLUMN ktek_pk_idresultquestionnaireitem SET DEFAULT nextval('ktek_result_questionnaireitem_ktek_pk_idresultquestionnaire_seq'::regclass);


--
-- TOC entry 2000 (class 2604 OID 17199)
-- Name: ktek_fk_idresultquestionnairesection; Type: DEFAULT; Schema: ktek_questionnaire; Owner: ktek_usr
--

ALTER TABLE ONLY ktek_result_questionnaireitem ALTER COLUMN ktek_fk_idresultquestionnairesection SET DEFAULT nextval('ktek_result_questionnaireitem_ktek_fk_idresultquestionnaire_seq'::regclass);


--
-- TOC entry 2001 (class 2604 OID 17220)
-- Name: ktek_pk_idresultquestionnairesection; Type: DEFAULT; Schema: ktek_questionnaire; Owner: ktek_usr
--

ALTER TABLE ONLY ktek_result_questionnairesection ALTER COLUMN ktek_pk_idresultquestionnairesection SET DEFAULT nextval('ktek_result_questionnairesect_ktek_pk_idresultquestionnaire_seq'::regclass);


--
-- TOC entry 2002 (class 2604 OID 17221)
-- Name: ktek_fk_idresultquestionnaire; Type: DEFAULT; Schema: ktek_questionnaire; Owner: ktek_usr
--

ALTER TABLE ONLY ktek_result_questionnairesection ALTER COLUMN ktek_fk_idresultquestionnaire SET DEFAULT nextval('ktek_result_questionnairesect_ktek_fk_idresultquestionnaire_seq'::regclass);


--
-- TOC entry 2009 (class 2604 OID 17321)
-- Name: ktek_pk_iduserquestionnaireplanning; Type: DEFAULT; Schema: ktek_questionnaire; Owner: ktek_usr
--

ALTER TABLE ONLY ktek_userquestionnaire_planning ALTER COLUMN ktek_pk_iduserquestionnaireplanning SET DEFAULT nextval('ktek_userquestionnaire_planni_ktek_pk_iduserquestionnairepl_seq'::regclass);


SET search_path = ktek_commons, pg_catalog;


--
-- TOC entry 2298 (class 0 OID 0)
-- Dependencies: 175
-- Name: ktek_auditaccesslog_idaccesseduser_seq; Type: SEQUENCE SET; Schema: ktek_commons; Owner: ktek_usr
--

SELECT pg_catalog.setval('ktek_auditaccesslog_idaccesseduser_seq', 1, false);


--
-- TOC entry 2299 (class 0 OID 0)
-- Dependencies: 174
-- Name: ktek_auditaccesslog_idaccessuser_seq; Type: SEQUENCE SET; Schema: ktek_commons; Owner: ktek_usr
--

SELECT pg_catalog.setval('ktek_auditaccesslog_idaccessuser_seq', 1, false);


--
-- TOC entry 2300 (class 0 OID 0)
-- Dependencies: 173
-- Name: ktek_auditaccesslog_ktek_pk_idauditaccesslog_seq; Type: SEQUENCE SET; Schema: ktek_commons; Owner: ktek_usr
--

SELECT pg_catalog.setval('ktek_auditaccesslog_ktek_pk_idauditaccesslog_seq', 4, true);

--
-- TOC entry 2301 (class 0 OID 0)
-- Dependencies: 179
-- Name: ktek_language_ktek_pk_idlanguage_seq; Type: SEQUENCE SET; Schema: ktek_commons; Owner: ktek_usr
--

SELECT pg_catalog.setval('ktek_language_ktek_pk_idlanguage_seq', 1, false);


--
-- TOC entry 2302 (class 0 OID 0)
-- Dependencies: 220
-- Name: ktek_pathology_ktek_pk_idpathology_seq; Type: SEQUENCE SET; Schema: ktek_commons; Owner: ktek_usr
--

SELECT pg_catalog.setval('ktek_pathology_ktek_pk_idpathology_seq', 1, false);



--
-- TOC entry 2303 (class 0 OID 0)
-- Dependencies: 184
-- Name: ktek_tpsettings_ktek_fk_idlanguage_seq; Type: SEQUENCE SET; Schema: ktek_commons; Owner: ktek_usr
--

SELECT pg_catalog.setval('ktek_tpsettings_ktek_fk_idlanguage_seq', 1, false);


--
-- TOC entry 2304 (class 0 OID 0)
-- Dependencies: 183
-- Name: ktek_tpsettings_ktek_fk_iduser_seq; Type: SEQUENCE SET; Schema: ktek_commons; Owner: ktek_usr
--

SELECT pg_catalog.setval('ktek_tpsettings_ktek_fk_iduser_seq', 1, false);



--
-- TOC entry 2305 (class 0 OID 0)
-- Dependencies: 189
-- Name: ktek_translation_text_ktek_fk_language_seq; Type: SEQUENCE SET; Schema: ktek_commons; Owner: ktek_usr
--

SELECT pg_catalog.setval('ktek_translation_text_ktek_fk_language_seq', 1, false);


--
-- TOC entry 2306 (class 0 OID 0)
-- Dependencies: 188
-- Name: ktek_translation_text_ktek_pk_translation_text_seq; Type: SEQUENCE SET; Schema: ktek_commons; Owner: ktek_usr
--

SELECT pg_catalog.setval('ktek_translation_text_ktek_pk_translation_text_seq', 1, false);




--
-- TOC entry 2307 (class 0 OID 0)
-- Dependencies: 186
-- Name: ktek_user_ext_ktek_fk_iduser_seq; Type: SEQUENCE SET; Schema: ktek_commons; Owner: ktek_usr
--

SELECT pg_catalog.setval('ktek_user_ext_ktek_fk_iduser_seq', 1, false);


--
-- TOC entry 2308 (class 0 OID 0)
-- Dependencies: 177
-- Name: ktek_user_ktek_pk_iduser_seq; Type: SEQUENCE SET; Schema: ktek_commons; Owner: ktek_usr
--

SELECT pg_catalog.setval('ktek_user_ktek_pk_iduser_seq', 8, true);




--
-- TOC entry 2309 (class 0 OID 0)
-- Dependencies: 181
-- Name: ktek_usersessiondata_ktek_fk_iduser_seq; Type: SEQUENCE SET; Schema: ktek_commons; Owner: ktek_usr
--

SELECT pg_catalog.setval('ktek_usersessiondata_ktek_fk_iduser_seq', 1, false);


SET search_path = ktek_questionnaire, pg_catalog;




--
-- TOC entry 2310 (class 0 OID 0)
-- Dependencies: 208
-- Name: ktek_codification_ktek_pk_idcodification_seq; Type: SEQUENCE SET; Schema: ktek_questionnaire; Owner: ktek_usr
--

SELECT pg_catalog.setval('ktek_codification_ktek_pk_idcodification_seq', 1, false);




--
-- TOC entry 2311 (class 0 OID 0)
-- Dependencies: 216
-- Name: ktek_formatquestionnaire_ktek_pk_idformatquestionnaire_seq; Type: SEQUENCE SET; Schema: ktek_questionnaire; Owner: ktek_usr
--

SELECT pg_catalog.setval('ktek_formatquestionnaire_ktek_pk_idformatquestionnaire_seq', 1, false);




--
-- TOC entry 2312 (class 0 OID 0)
-- Dependencies: 206
-- Name: ktek_questionnaireitem_codification_ktek_fk_idcodification_seq; Type: SEQUENCE SET; Schema: ktek_questionnaire; Owner: ktek_usr
--

SELECT pg_catalog.setval('ktek_questionnaireitem_codification_ktek_fk_idcodification_seq', 1, false);



--
-- TOC entry 2313 (class 0 OID 0)
-- Dependencies: 201
-- Name: ktek_result_questionnaire_ktek_fk_iduserquestionnaireplanni_seq; Type: SEQUENCE SET; Schema: ktek_questionnaire; Owner: ktek_usr
--

SELECT pg_catalog.setval('ktek_result_questionnaire_ktek_fk_iduserquestionnaireplanni_seq', 1, false);


--
-- TOC entry 2314 (class 0 OID 0)
-- Dependencies: 200
-- Name: ktek_result_questionnaire_ktek_pk_idresultquestionnaire_seq; Type: SEQUENCE SET; Schema: ktek_questionnaire; Owner: ktek_usr
--

SELECT pg_catalog.setval('ktek_result_questionnaire_ktek_pk_idresultquestionnaire_seq', 1, true);


--
-- TOC entry 2315 (class 0 OID 0)
-- Dependencies: 193
-- Name: ktek_result_questionnaireitem_ktek_fk_idresultquestionnaire_seq; Type: SEQUENCE SET; Schema: ktek_questionnaire; Owner: ktek_usr
--

SELECT pg_catalog.setval('ktek_result_questionnaireitem_ktek_fk_idresultquestionnaire_seq', 1, false);


--
-- TOC entry 2316 (class 0 OID 0)
-- Dependencies: 192
-- Name: ktek_result_questionnaireitem_ktek_pk_idresultquestionnaire_seq; Type: SEQUENCE SET; Schema: ktek_questionnaire; Owner: ktek_usr
--

SELECT pg_catalog.setval('ktek_result_questionnaireitem_ktek_pk_idresultquestionnaire_seq', 1, true);


--
-- TOC entry 2317 (class 0 OID 0)
-- Dependencies: 197
-- Name: ktek_result_questionnairesect_ktek_fk_idresultquestionnaire_seq; Type: SEQUENCE SET; Schema: ktek_questionnaire; Owner: ktek_usr
--

SELECT pg_catalog.setval('ktek_result_questionnairesect_ktek_fk_idresultquestionnaire_seq', 1, false);


--
-- TOC entry 2318 (class 0 OID 0)
-- Dependencies: 196
-- Name: ktek_result_questionnairesect_ktek_pk_idresultquestionnaire_seq; Type: SEQUENCE SET; Schema: ktek_questionnaire; Owner: ktek_usr
--

SELECT pg_catalog.setval('ktek_result_questionnairesect_ktek_pk_idresultquestionnaire_seq', 1, true);




--
-- TOC entry 2319 (class 0 OID 0)
-- Dependencies: 218
-- Name: ktek_userquestionnaire_planni_ktek_pk_iduserquestionnairepl_seq; Type: SEQUENCE SET; Schema: ktek_questionnaire; Owner: ktek_usr
--

SELECT pg_catalog.setval('ktek_userquestionnaire_planni_ktek_pk_iduserquestionnairepl_seq', 1, true);



SET search_path = ktek_commons, pg_catalog;

--
-- TOC entry 2012 (class 2606 OID 17122)
-- Name: ktek_auditaccesslog_pkey; Type: CONSTRAINT; Schema: ktek_commons; Owner: ktek_usr; Tablespace: 
--

ALTER TABLE ONLY ktek_auditaccesslog
    ADD CONSTRAINT ktek_auditaccesslog_pkey PRIMARY KEY (ktek_pk_idauditaccesslog);


--
-- TOC entry 2018 (class 2606 OID 17138)
-- Name: ktek_language_pkey; Type: CONSTRAINT; Schema: ktek_commons; Owner: ktek_usr; Tablespace: 
--

ALTER TABLE ONLY ktek_language
    ADD CONSTRAINT ktek_language_pkey PRIMARY KEY (ktek_pk_idlanguage);


--
-- TOC entry 2074 (class 2606 OID 17333)
-- Name: ktek_pathology_ktek_uk_codpathology_key; Type: CONSTRAINT; Schema: ktek_commons; Owner: ktek_usr; Tablespace: 
--

ALTER TABLE ONLY ktek_pathology
    ADD CONSTRAINT ktek_pathology_ktek_uk_codpathology_key UNIQUE (ktek_uk_codpathology);


--
-- TOC entry 2076 (class 2606 OID 17331)
-- Name: ktek_pathology_pkey; Type: CONSTRAINT; Schema: ktek_commons; Owner: ktek_usr; Tablespace: 
--

ALTER TABLE ONLY ktek_pathology
    ADD CONSTRAINT ktek_pathology_pkey PRIMARY KEY (ktek_pk_idpathology);


--
-- TOC entry 2022 (class 2606 OID 17157)
-- Name: ktek_tpsettings_pkey; Type: CONSTRAINT; Schema: ktek_commons; Owner: ktek_usr; Tablespace: 
--

ALTER TABLE ONLY ktek_tpsettings
    ADD CONSTRAINT ktek_tpsettings_pkey PRIMARY KEY (ktek_fk_iduser);


--
-- TOC entry 2028 (class 2606 OID 17179)
-- Name: ktek_translation_text_pkey; Type: CONSTRAINT; Schema: ktek_commons; Owner: ktek_usr; Tablespace: 
--

ALTER TABLE ONLY ktek_translation_text
    ADD CONSTRAINT ktek_translation_text_pkey PRIMARY KEY (ktek_pk_translation_text);


--
-- TOC entry 2025 (class 2606 OID 17165)
-- Name: ktek_user_ext_pkey; Type: CONSTRAINT; Schema: ktek_commons; Owner: ktek_usr; Tablespace: 
--

ALTER TABLE ONLY ktek_user_ext
    ADD CONSTRAINT ktek_user_ext_pkey PRIMARY KEY (ktek_fk_iduser);


--
-- TOC entry 2015 (class 2606 OID 17130)
-- Name: ktek_user_pkey; Type: CONSTRAINT; Schema: ktek_commons; Owner: ktek_usr; Tablespace: 
--

ALTER TABLE ONLY ktek_user
    ADD CONSTRAINT ktek_user_pkey PRIMARY KEY (ktek_pk_iduser);


--
-- TOC entry 2020 (class 2606 OID 17146)
-- Name: ktek_usersessiondata_pkey; Type: CONSTRAINT; Schema: ktek_commons; Owner: ktek_usr; Tablespace: 
--

ALTER TABLE ONLY ktek_usersessiondata
    ADD CONSTRAINT ktek_usersessiondata_pkey PRIMARY KEY (ktek_fk_iduser);


SET search_path = ktek_questionnaire, pg_catalog;

--
-- TOC entry 2049 (class 2606 OID 17255)
-- Name: ktek_answer_pkey; Type: CONSTRAINT; Schema: ktek_questionnaire; Owner: ktek_usr; Tablespace: 
--

ALTER TABLE ONLY ktek_answer
    ADD CONSTRAINT ktek_answer_pkey PRIMARY KEY (ktek_pk_idanswer);


--
-- TOC entry 2058 (class 2606 OID 17281)
-- Name: ktek_answerset_answer_pkey; Type: CONSTRAINT; Schema: ktek_questionnaire; Owner: ktek_usr; Tablespace: 
--

ALTER TABLE ONLY ktek_answerset_answer
    ADD CONSTRAINT ktek_answerset_answer_pkey PRIMARY KEY (ktek_fk_idanswerset, ktek_fk_idanswer);


--
-- TOC entry 2046 (class 2606 OID 17247)
-- Name: ktek_answerset_pkey; Type: CONSTRAINT; Schema: ktek_questionnaire; Owner: ktek_usr; Tablespace: 
--

ALTER TABLE ONLY ktek_answerset
    ADD CONSTRAINT ktek_answerset_pkey PRIMARY KEY (ktek_pk_idanswerset);


--
-- TOC entry 2056 (class 2606 OID 17276)
-- Name: ktek_codification_pkey; Type: CONSTRAINT; Schema: ktek_questionnaire; Owner: ktek_usr; Tablespace: 
--

ALTER TABLE ONLY ktek_codification
    ADD CONSTRAINT ktek_codification_pkey PRIMARY KEY (ktek_pk_idcodification);


--
-- TOC entry 2070 (class 2606 OID 17315)
-- Name: ktek_formatquestionnaire_pkey; Type: CONSTRAINT; Schema: ktek_questionnaire; Owner: ktek_usr; Tablespace: 
--

ALTER TABLE ONLY ktek_formatquestionnaire
    ADD CONSTRAINT ktek_formatquestionnaire_pkey PRIMARY KEY (ktek_pk_idformatquestionnaire);


--
-- TOC entry 2062 (class 2606 OID 17291)
-- Name: ktek_parameter_pkey; Type: CONSTRAINT; Schema: ktek_questionnaire; Owner: ktek_usr; Tablespace: 
--

ALTER TABLE ONLY ktek_parameter
    ADD CONSTRAINT ktek_parameter_pkey PRIMARY KEY (ktek_fk_idquestionnaireitem);


--
-- TOC entry 2064 (class 2606 OID 17296)
-- Name: ktek_qitem_section_pkey; Type: CONSTRAINT; Schema: ktek_questionnaire; Owner: ktek_usr; Tablespace: 
--

ALTER TABLE ONLY ktek_qitem_section
    ADD CONSTRAINT ktek_qitem_section_pkey PRIMARY KEY (ktek_fk_idquestionnairesection, ktek_fk_idquestionnaireitem);


--
-- TOC entry 2066 (class 2606 OID 17301)
-- Name: ktek_qsection_questionnaire_pkey; Type: CONSTRAINT; Schema: ktek_questionnaire; Owner: ktek_usr; Tablespace: 
--

ALTER TABLE ONLY ktek_qsection_questionnaire
    ADD CONSTRAINT ktek_qsection_questionnaire_pkey PRIMARY KEY (ktek_fk_idquestionnaire, ktek_fk_idquestionnairesection);


--
-- TOC entry 2068 (class 2606 OID 17307)
-- Name: ktek_question_pkey; Type: CONSTRAINT; Schema: ktek_questionnaire; Owner: ktek_usr; Tablespace: 
--

ALTER TABLE ONLY ktek_question
    ADD CONSTRAINT ktek_question_pkey PRIMARY KEY (ktek_fk_idquestionnaireitem);


--
-- TOC entry 2031 (class 2606 OID 17190)
-- Name: ktek_questionnaire_ktek_uk_codquestionnaire_key; Type: CONSTRAINT; Schema: ktek_questionnaire; Owner: ktek_usr; Tablespace: 
--

ALTER TABLE ONLY ktek_questionnaire
    ADD CONSTRAINT ktek_questionnaire_ktek_uk_codquestionnaire_key UNIQUE (ktek_uk_codquestionnaire);


--
-- TOC entry 2033 (class 2606 OID 17188)
-- Name: ktek_questionnaire_pkey; Type: CONSTRAINT; Schema: ktek_questionnaire; Owner: ktek_usr; Tablespace: 
--

ALTER TABLE ONLY ktek_questionnaire
    ADD CONSTRAINT ktek_questionnaire_pkey PRIMARY KEY (ktek_pk_idquestionnaire);


--
-- TOC entry 2078 (class 2606 OID 17341)
-- Name: ktek_questionnaireconfiguration_pkey; Type: CONSTRAINT; Schema: ktek_questionnaire; Owner: ktek_usr; Tablespace: 
--

ALTER TABLE ONLY ktek_questionnaireconfiguration
    ADD CONSTRAINT ktek_questionnaireconfiguration_pkey PRIMARY KEY (ktek_pk_ktek_idquestionnaireconfiguration);


--
-- TOC entry 2054 (class 2606 OID 17268)
-- Name: ktek_questionnaireitem_codification_pkey; Type: CONSTRAINT; Schema: ktek_questionnaire; Owner: ktek_usr; Tablespace: 
--

ALTER TABLE ONLY ktek_questionnaireitem_codification
    ADD CONSTRAINT ktek_questionnaireitem_codification_pkey PRIMARY KEY (ktek_fk_idquestionnaireitem, ktek_fk_idcodification);


--
-- TOC entry 2038 (class 2606 OID 17212)
-- Name: ktek_questionnaireitem_pkey; Type: CONSTRAINT; Schema: ktek_questionnaire; Owner: ktek_usr; Tablespace: 
--

ALTER TABLE ONLY ktek_questionnaireitem
    ADD CONSTRAINT ktek_questionnaireitem_pkey PRIMARY KEY (ktek_pk_idquestionnaireitem);


--
-- TOC entry 2042 (class 2606 OID 17231)
-- Name: ktek_questionnairesection_pkey; Type: CONSTRAINT; Schema: ktek_questionnaire; Owner: ktek_usr; Tablespace: 
--

ALTER TABLE ONLY ktek_questionnairesection
    ADD CONSTRAINT ktek_questionnairesection_pkey PRIMARY KEY (ktek_pk_idquestionnairesection);


--
-- TOC entry 2044 (class 2606 OID 17242)
-- Name: ktek_result_questionnaire_pkey; Type: CONSTRAINT; Schema: ktek_questionnaire; Owner: ktek_usr; Tablespace: 
--

ALTER TABLE ONLY ktek_result_questionnaire
    ADD CONSTRAINT ktek_result_questionnaire_pkey PRIMARY KEY (ktek_pk_idresultquestionnaire);


--
-- TOC entry 2035 (class 2606 OID 17204)
-- Name: ktek_result_questionnaireitem_pkey; Type: CONSTRAINT; Schema: ktek_questionnaire; Owner: ktek_usr; Tablespace: 
--

ALTER TABLE ONLY ktek_result_questionnaireitem
    ADD CONSTRAINT ktek_result_questionnaireitem_pkey PRIMARY KEY (ktek_pk_idresultquestionnaireitem);


--
-- TOC entry 2040 (class 2606 OID 17223)
-- Name: ktek_result_questionnairesection_pkey; Type: CONSTRAINT; Schema: ktek_questionnaire; Owner: ktek_usr; Tablespace: 
--

ALTER TABLE ONLY ktek_result_questionnairesection
    ADD CONSTRAINT ktek_result_questionnairesection_pkey PRIMARY KEY (ktek_pk_idresultquestionnairesection);


--
-- TOC entry 2060 (class 2606 OID 17286)
-- Name: ktek_unit_parameter_pkey; Type: CONSTRAINT; Schema: ktek_questionnaire; Owner: ktek_usr; Tablespace: 
--

ALTER TABLE ONLY ktek_unit_parameter
    ADD CONSTRAINT ktek_unit_parameter_pkey PRIMARY KEY (ktek_fk_idquestionnaireitem, ktek_fk_idunit);


--
-- TOC entry 2052 (class 2606 OID 17260)
-- Name: ktek_unit_pkey; Type: CONSTRAINT; Schema: ktek_questionnaire; Owner: ktek_usr; Tablespace: 
--

ALTER TABLE ONLY ktek_unit
    ADD CONSTRAINT ktek_unit_pkey PRIMARY KEY (ktek_pk_idunit);


--
-- TOC entry 2072 (class 2606 OID 17323)
-- Name: ktek_userquestionnaire_planning_pkey; Type: CONSTRAINT; Schema: ktek_questionnaire; Owner: ktek_usr; Tablespace: 
--

ALTER TABLE ONLY ktek_userquestionnaire_planning
    ADD CONSTRAINT ktek_userquestionnaire_planning_pkey PRIMARY KEY (ktek_pk_iduserquestionnaireplanning);


SET search_path = ktek_commons, pg_catalog;

--
-- TOC entry 2026 (class 1259 OID 17490)
-- Name: ktek_idx_ktek_translation_text; Type: INDEX; Schema: ktek_commons; Owner: ktek_usr; Tablespace: 
--

CREATE INDEX ktek_idx_ktek_translation_text ON ktek_translation_text USING btree (ktek_idregister, ktek_keycolum, ktek_fk_language);


--
-- TOC entry 2016 (class 1259 OID 17488)
-- Name: ktek_language_ktek_uk_codlanguage_key; Type: INDEX; Schema: ktek_commons; Owner: ktek_usr; Tablespace: 
--

CREATE UNIQUE INDEX ktek_language_ktek_uk_codlanguage_key ON ktek_language USING btree (ktek_uk_codlanguage);


--
-- TOC entry 2029 (class 1259 OID 17491)
-- Name: ktek_uk_translation; Type: INDEX; Schema: ktek_commons; Owner: ktek_usr; Tablespace: 
--

CREATE UNIQUE INDEX ktek_uk_translation ON ktek_translation_text USING btree (ktek_keycolum, ktek_fk_language, ktek_idregister);


--
-- TOC entry 2023 (class 1259 OID 17489)
-- Name: ktek_user_ext_ktek_uk_coduserid_key; Type: INDEX; Schema: ktek_commons; Owner: ktek_usr; Tablespace: 
--

CREATE UNIQUE INDEX ktek_user_ext_ktek_uk_coduserid_key ON ktek_user_ext USING btree (ktek_uk_coduserid);


--
-- TOC entry 2013 (class 1259 OID 17487)
-- Name: ktek_user_ktek_uk_coduser_key; Type: INDEX; Schema: ktek_commons; Owner: ktek_usr; Tablespace: 
--

CREATE UNIQUE INDEX ktek_user_ktek_uk_coduser_key ON ktek_user USING btree (ktek_uk_coduser);


SET search_path = ktek_questionnaire, pg_catalog;

--
-- TOC entry 2047 (class 1259 OID 17493)
-- Name: ktek_answer_ktek_uk_codanswer_key; Type: INDEX; Schema: ktek_questionnaire; Owner: ktek_usr; Tablespace: 
--

CREATE UNIQUE INDEX ktek_answer_ktek_uk_codanswer_key ON ktek_answer USING btree (ktek_uk_codanswer);


--
-- TOC entry 2036 (class 1259 OID 17492)
-- Name: ktek_questionnaireitem_ktek_uk_codquestionnaireitem_key; Type: INDEX; Schema: ktek_questionnaire; Owner: ktek_usr; Tablespace: 
--

CREATE UNIQUE INDEX ktek_questionnaireitem_ktek_uk_codquestionnaireitem_key ON ktek_questionnaireitem USING btree (ktek_uk_codquestionnaireitem);


--
-- TOC entry 2050 (class 1259 OID 17494)
-- Name: ktek_unit_ktek_uk_codunit_key; Type: INDEX; Schema: ktek_questionnaire; Owner: ktek_usr; Tablespace: 
--

CREATE UNIQUE INDEX ktek_unit_ktek_uk_codunit_key ON ktek_unit USING btree (ktek_uk_codunit);


SET search_path = ktek_commons, pg_catalog;

--
-- TOC entry 2079 (class 2606 OID 17472)
-- Name: FKktek_audit297351; Type: FK CONSTRAINT; Schema: ktek_commons; Owner: ktek_usr
--

ALTER TABLE ONLY ktek_auditaccesslog
    ADD CONSTRAINT "FKktek_audit297351" FOREIGN KEY (idaccessuser) REFERENCES ktek_user(ktek_pk_iduser);


--
-- TOC entry 2080 (class 2606 OID 17477)
-- Name: FKktek_audit692390; Type: FK CONSTRAINT; Schema: ktek_commons; Owner: ktek_usr
--

ALTER TABLE ONLY ktek_auditaccesslog
    ADD CONSTRAINT "FKktek_audit692390" FOREIGN KEY (idaccesseduser) REFERENCES ktek_user(ktek_pk_iduser);


--
-- TOC entry 2083 (class 2606 OID 17352)
-- Name: FKktek_tpset525714; Type: FK CONSTRAINT; Schema: ktek_commons; Owner: ktek_usr
--

ALTER TABLE ONLY ktek_tpsettings
    ADD CONSTRAINT "FKktek_tpset525714" FOREIGN KEY (ktek_fk_idlanguage) REFERENCES ktek_language(ktek_pk_idlanguage);


--
-- TOC entry 2082 (class 2606 OID 17347)
-- Name: FKktek_tpset753541; Type: FK CONSTRAINT; Schema: ktek_commons; Owner: ktek_usr
--

ALTER TABLE ONLY ktek_tpsettings
    ADD CONSTRAINT "FKktek_tpset753541" FOREIGN KEY (ktek_fk_iduser) REFERENCES ktek_user(ktek_pk_iduser);


--
-- TOC entry 2085 (class 2606 OID 17357)
-- Name: FKktek_trans804107; Type: FK CONSTRAINT; Schema: ktek_commons; Owner: ktek_usr
--

ALTER TABLE ONLY ktek_translation_text
    ADD CONSTRAINT "FKktek_trans804107" FOREIGN KEY (ktek_fk_language) REFERENCES ktek_language(ktek_pk_idlanguage);


--
-- TOC entry 2084 (class 2606 OID 17342)
-- Name: FKktek_user_934168; Type: FK CONSTRAINT; Schema: ktek_commons; Owner: ktek_usr
--

ALTER TABLE ONLY ktek_user_ext
    ADD CONSTRAINT "FKktek_user_934168" FOREIGN KEY (ktek_fk_iduser) REFERENCES ktek_user(ktek_pk_iduser);


--
-- TOC entry 2081 (class 2606 OID 17362)
-- Name: FKktek_users202099; Type: FK CONSTRAINT; Schema: ktek_commons; Owner: ktek_usr
--

ALTER TABLE ONLY ktek_usersessiondata
    ADD CONSTRAINT "FKktek_users202099" FOREIGN KEY (ktek_fk_iduser) REFERENCES ktek_user(ktek_pk_iduser);


SET search_path = ktek_questionnaire, pg_catalog;

--
-- TOC entry 2095 (class 2606 OID 17392)
-- Name: FKktek_answe395016; Type: FK CONSTRAINT; Schema: ktek_questionnaire; Owner: ktek_usr
--

ALTER TABLE ONLY ktek_answerset_answer
    ADD CONSTRAINT "FKktek_answe395016" FOREIGN KEY (ktek_fk_idanswer) REFERENCES ktek_answer(ktek_pk_idanswer);


--
-- TOC entry 2092 (class 2606 OID 17452)
-- Name: FKktek_answe56225; Type: FK CONSTRAINT; Schema: ktek_questionnaire; Owner: ktek_usr
--

ALTER TABLE ONLY ktek_answer
    ADD CONSTRAINT "FKktek_answe56225" FOREIGN KEY (ktek_fk_idquestionnaireitem) REFERENCES ktek_question(ktek_fk_idquestionnaireitem);


--
-- TOC entry 2096 (class 2606 OID 17397)
-- Name: FKktek_answe800049; Type: FK CONSTRAINT; Schema: ktek_questionnaire; Owner: ktek_usr
--

ALTER TABLE ONLY ktek_answerset_answer
    ADD CONSTRAINT "FKktek_answe800049" FOREIGN KEY (ktek_fk_idanswerset) REFERENCES ktek_answerset(ktek_pk_idanswerset);


--
-- TOC entry 2106 (class 2606 OID 17457)
-- Name: FKktek_forma691030; Type: FK CONSTRAINT; Schema: ktek_questionnaire; Owner: ktek_usr
--

ALTER TABLE ONLY ktek_formatquestionnaire
    ADD CONSTRAINT "FKktek_forma691030" FOREIGN KEY (ktek_fk_questionnaire) REFERENCES ktek_questionnaire(ktek_pk_idquestionnaire);


--
-- TOC entry 2099 (class 2606 OID 17437)
-- Name: FKktek_param464239; Type: FK CONSTRAINT; Schema: ktek_questionnaire; Owner: ktek_usr
--

ALTER TABLE ONLY ktek_parameter
    ADD CONSTRAINT "FKktek_param464239" FOREIGN KEY (ktek_fk_idquestionnaireitem) REFERENCES ktek_questionnaireitem(ktek_pk_idquestionnaireitem);


--
-- TOC entry 2101 (class 2606 OID 17427)
-- Name: FKktek_qitem522456; Type: FK CONSTRAINT; Schema: ktek_questionnaire; Owner: ktek_usr
--

ALTER TABLE ONLY ktek_qitem_section
    ADD CONSTRAINT "FKktek_qitem522456" FOREIGN KEY (ktek_fk_idquestionnaireitem) REFERENCES ktek_questionnaireitem(ktek_pk_idquestionnaireitem);


--
-- TOC entry 2100 (class 2606 OID 17377)
-- Name: FKktek_qitem822786; Type: FK CONSTRAINT; Schema: ktek_questionnaire; Owner: ktek_usr
--

ALTER TABLE ONLY ktek_qitem_section
    ADD CONSTRAINT "FKktek_qitem822786" FOREIGN KEY (ktek_fk_idquestionnairesection) REFERENCES ktek_questionnairesection(ktek_pk_idquestionnairesection);


--
-- TOC entry 2102 (class 2606 OID 17367)
-- Name: FKktek_qsect522638; Type: FK CONSTRAINT; Schema: ktek_questionnaire; Owner: ktek_usr
--

ALTER TABLE ONLY ktek_qsection_questionnaire
    ADD CONSTRAINT "FKktek_qsect522638" FOREIGN KEY (ktek_fk_idquestionnaire) REFERENCES ktek_questionnaire(ktek_pk_idquestionnaire);


--
-- TOC entry 2103 (class 2606 OID 17372)
-- Name: FKktek_qsect992192; Type: FK CONSTRAINT; Schema: ktek_questionnaire; Owner: ktek_usr
--

ALTER TABLE ONLY ktek_qsection_questionnaire
    ADD CONSTRAINT "FKktek_qsect992192" FOREIGN KEY (ktek_fk_idquestionnairesection) REFERENCES ktek_questionnairesection(ktek_pk_idquestionnairesection);


--
-- TOC entry 2093 (class 2606 OID 17402)
-- Name: FKktek_quest272251; Type: FK CONSTRAINT; Schema: ktek_questionnaire; Owner: ktek_usr
--

ALTER TABLE ONLY ktek_questionnaireitem_codification
    ADD CONSTRAINT "FKktek_quest272251" FOREIGN KEY (ktek_fk_idcodification) REFERENCES ktek_codification(ktek_pk_idcodification);


--
-- TOC entry 2105 (class 2606 OID 17432)
-- Name: FKktek_quest600057; Type: FK CONSTRAINT; Schema: ktek_questionnaire; Owner: ktek_usr
--

ALTER TABLE ONLY ktek_question
    ADD CONSTRAINT "FKktek_quest600057" FOREIGN KEY (ktek_fk_idquestionnaireitem) REFERENCES ktek_questionnaireitem(ktek_pk_idquestionnaireitem);


--
-- TOC entry 2104 (class 2606 OID 17407)
-- Name: FKktek_quest934106; Type: FK CONSTRAINT; Schema: ktek_questionnaire; Owner: ktek_usr
--

ALTER TABLE ONLY ktek_question
    ADD CONSTRAINT "FKktek_quest934106" FOREIGN KEY (ktek_fk_idanswerset) REFERENCES ktek_answerset(ktek_pk_idanswerset);


--
-- TOC entry 2094 (class 2606 OID 17442)
-- Name: FKktek_quest948013; Type: FK CONSTRAINT; Schema: ktek_questionnaire; Owner: ktek_usr
--

ALTER TABLE ONLY ktek_questionnaireitem_codification
    ADD CONSTRAINT "FKktek_quest948013" FOREIGN KEY (ktek_fk_idquestionnaireitem) REFERENCES ktek_questionnaireitem(ktek_pk_idquestionnaireitem);


--
-- TOC entry 2088 (class 2606 OID 17412)
-- Name: FKktek_resul369619; Type: FK CONSTRAINT; Schema: ktek_questionnaire; Owner: ktek_usr
--

ALTER TABLE ONLY ktek_result_questionnairesection
    ADD CONSTRAINT "FKktek_resul369619" FOREIGN KEY (ktek_fk_idquestionnairesection) REFERENCES ktek_questionnairesection(ktek_pk_idquestionnairesection);


--
-- TOC entry 2089 (class 2606 OID 17417)
-- Name: FKktek_resul445950; Type: FK CONSTRAINT; Schema: ktek_questionnaire; Owner: ktek_usr
--

ALTER TABLE ONLY ktek_result_questionnairesection
    ADD CONSTRAINT "FKktek_resul445950" FOREIGN KEY (ktek_fk_idresultquestionnaire) REFERENCES ktek_result_questionnaire(ktek_pk_idresultquestionnaire);


--
-- TOC entry 2090 (class 2606 OID 17462)
-- Name: FKktek_resul461432; Type: FK CONSTRAINT; Schema: ktek_questionnaire; Owner: ktek_usr
--

ALTER TABLE ONLY ktek_result_questionnaire
    ADD CONSTRAINT "FKktek_resul461432" FOREIGN KEY (ktek_fk_idquestionnaire) REFERENCES ktek_questionnaire(ktek_pk_idquestionnaire);


--
-- TOC entry 2086 (class 2606 OID 17422)
-- Name: FKktek_resul733126; Type: FK CONSTRAINT; Schema: ktek_questionnaire; Owner: ktek_usr
--

ALTER TABLE ONLY ktek_result_questionnaireitem
    ADD CONSTRAINT "FKktek_resul733126" FOREIGN KEY (ktek_fk_idresultquestionnairesection) REFERENCES ktek_result_questionnairesection(ktek_pk_idresultquestionnairesection);


--
-- TOC entry 2087 (class 2606 OID 17447)
-- Name: FKktek_resul835527; Type: FK CONSTRAINT; Schema: ktek_questionnaire; Owner: ktek_usr
--

ALTER TABLE ONLY ktek_result_questionnaireitem
    ADD CONSTRAINT "FKktek_resul835527" FOREIGN KEY (ktek_fk_idquestionnaireitem) REFERENCES ktek_questionnaireitem(ktek_pk_idquestionnaireitem);


--
-- TOC entry 2091 (class 2606 OID 17482)
-- Name: FKktek_resul904777; Type: FK CONSTRAINT; Schema: ktek_questionnaire; Owner: ktek_usr
--

ALTER TABLE ONLY ktek_result_questionnaire
    ADD CONSTRAINT "FKktek_resul904777" FOREIGN KEY (ktek_fk_iduserquestionnaireplanning) REFERENCES ktek_userquestionnaire_planning(ktek_pk_iduserquestionnaireplanning);


--
-- TOC entry 2098 (class 2606 OID 17387)
-- Name: FKktek_unit_265369; Type: FK CONSTRAINT; Schema: ktek_questionnaire; Owner: ktek_usr
--

ALTER TABLE ONLY ktek_unit_parameter
    ADD CONSTRAINT "FKktek_unit_265369" FOREIGN KEY (ktek_fk_idunit) REFERENCES ktek_unit(ktek_pk_idunit);


--
-- TOC entry 2097 (class 2606 OID 17382)
-- Name: FKktek_unit_506503; Type: FK CONSTRAINT; Schema: ktek_questionnaire; Owner: ktek_usr
--

ALTER TABLE ONLY ktek_unit_parameter
    ADD CONSTRAINT "FKktek_unit_506503" FOREIGN KEY (ktek_fk_idquestionnaireitem) REFERENCES ktek_parameter(ktek_fk_idquestionnaireitem);


--
-- TOC entry 2107 (class 2606 OID 17467)
-- Name: FKktek_userq8515; Type: FK CONSTRAINT; Schema: ktek_questionnaire; Owner: ktek_usr
--

ALTER TABLE ONLY ktek_userquestionnaire_planning
    ADD CONSTRAINT "FKktek_userq8515" FOREIGN KEY (ktek_fk_idquestionnaire) REFERENCES ktek_questionnaire(ktek_pk_idquestionnaire);


--
-- TOC entry 2270 (class 0 OID 0)
-- Dependencies: 7
-- Name: ktek_commons; Type: ACL; Schema: -; Owner: ktek_usr
--

REVOKE ALL ON SCHEMA ktek_commons FROM PUBLIC;
REVOKE ALL ON SCHEMA ktek_commons FROM ktek_usr;
GRANT ALL ON SCHEMA ktek_commons TO ktek_usr;


--
-- TOC entry 2271 (class 0 OID 0)
-- Dependencies: 8
-- Name: ktek_general; Type: ACL; Schema: -; Owner: ktek_usr
--

REVOKE ALL ON SCHEMA ktek_general FROM PUBLIC;
REVOKE ALL ON SCHEMA ktek_general FROM ktek_usr;
GRANT ALL ON SCHEMA ktek_general TO ktek_usr;


--
-- TOC entry 2272 (class 0 OID 0)
-- Dependencies: 9
-- Name: ktek_questionnaire; Type: ACL; Schema: -; Owner: ktek_usr
--

REVOKE ALL ON SCHEMA ktek_questionnaire FROM PUBLIC;
REVOKE ALL ON SCHEMA ktek_questionnaire FROM ktek_usr;
GRANT ALL ON SCHEMA ktek_questionnaire TO ktek_usr;


--
-- TOC entry 2274 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2015-06-19 13:07:53
