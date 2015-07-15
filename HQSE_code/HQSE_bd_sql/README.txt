/*
*
* Copyright 2015 IK4-Tekniker All Rights Reserved
*
* This folder is part of Health Questionnaire SE at FISTAR https://www.fi-star.eu/  
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

This folder contains the SQL scripts to create the PostgreSQL database of Health Questionnaire SE.
Tested on version PostgreSQL 9.3 

Steps to do :

1 - Install PostgreSQL : Information on how to install PostgreSQL see https://wiki.postgresql.org/wiki/Detailed_installation_guides 

2 - Create the folders for the database tablespaces . See sample file create_database_folders_commands.txt

3 - Create the database : execute the files 

1_HQSE_beta_create_roles_tablespaces_database.sql 

To execute the file to create roles, tablespaces and database you can do this
sudo -u postgres psql
postgres=#\i 1_HQSE_beta_create_roles_tablespaces_database.sql

2_HQSE_beta_create_schemas_tables.sql
To execute the file to create the database structure you must execute the sql script at database ktek
sudo -u postgres psql -d ktek -f 2_HQSE_beta_create_schemas_tables.sql