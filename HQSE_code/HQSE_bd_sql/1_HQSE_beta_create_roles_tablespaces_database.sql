--
-- PostgreSQL database cluster dump
--

-- Started on 2015-06-19 13:07:01

SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;

--
-- Roles
--

CREATE ROLE ktek_batch;
ALTER ROLE ktek_batch WITH NOSUPERUSER INHERIT NOCREATEROLE NOCREATEDB LOGIN NOREPLICATION VALID UNTIL 'infinity';
CREATE ROLE ktek_qry;
ALTER ROLE ktek_qry WITH NOSUPERUSER INHERIT NOCREATEROLE NOCREATEDB LOGIN NOREPLICATION PASSWORD 'md517b33ba0dc922740893a5f202392f6ce' VALID UNTIL 'infinity';
CREATE ROLE ktek_reader;
ALTER ROLE ktek_reader WITH NOSUPERUSER INHERIT NOCREATEROLE NOCREATEDB NOLOGIN NOREPLICATION VALID UNTIL 'infinity';
CREATE ROLE ktek_usr;
ALTER ROLE ktek_usr WITH NOSUPERUSER INHERIT NOCREATEROLE NOCREATEDB LOGIN NOREPLICATION PASSWORD 'md55ea0108207806eebdd0ddaa4704e9649' VALID UNTIL 'infinity';
CREATE ROLE ktek_writer;
ALTER ROLE ktek_writer WITH NOSUPERUSER INHERIT NOCREATEROLE NOCREATEDB NOLOGIN NOREPLICATION VALID UNTIL 'infinity';


--
-- Role memberships
--

GRANT ktek_reader TO ktek_qry GRANTED BY postgres;
GRANT ktek_writer TO ktek_batch GRANTED BY postgres;
GRANT ktek_writer TO ktek_usr GRANTED BY postgres;


--
-- Tablespaces
--

CREATE TABLESPACE ktek_data OWNER ktek_usr LOCATION '/opt/PostgreSQL/9.3/data/ktekdata';
CREATE TABLESPACE ktek_indexes OWNER ktek_usr LOCATION '/opt/PostgreSQL/9.3/data/ktekindexes';

--
-- ALTER Roles
--

ALTER ROLE ktek_usr SET default_tablespace TO 'ktek_data';
ALTER ROLE ktek_usr SET search_path TO ktek;


--
-- Database creation
--

CREATE DATABASE ktek WITH TEMPLATE = template0 OWNER = ktek_usr TABLESPACE = ktek_data;
REVOKE ALL ON DATABASE template1 FROM PUBLIC;
REVOKE ALL ON DATABASE template1 FROM postgres;
GRANT ALL ON DATABASE template1 TO postgres;
GRANT CONNECT ON DATABASE template1 TO PUBLIC;

