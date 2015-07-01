# FISTAR Health Questionnaire SE

This is the code repository of the Health Questionnaire SE (HQSE).

This project is part of the [FI-STAR][hqse1] project 

Check also the FI-STAR Catalogue entry for [Health Questionnaire SE][hqse2] 

#Requirements
* PostgreSQL 9.3
* Apache Tomcat 7.0.50 or higher

#Software base Installation
* Install [PostgreSQL 9.3][hqse3]
* Install [Apache Tomcat] [hqse4] 

#Configuration

* Update Apache Tomcat web.xml configuration file to enable CORSFilter adding the following filter definition
```sh
<filter>
  <filter-name>CorsFilter</filter-name>
  <filter-class>org.apache.catalina.filters.CorsFilter</filter-class>
  <init-param>
    <param-name>cors.allowed.headers</param-name>
    <param-value>Content-Type,X-Requested-With,accept,Origin,Access-Control-Request-Method,Access-Control-Request-Headers,token,idlang,status,iduser,iduserprogram,codtelecareprogram</param-value>
  </init-param>
  <init-param>
    <param-name>cors.allowed.methods</param-name>
    <param-value>GET,POST,HEAD,OPTIONS,PUT,DELETE,PATCH</param-value>
  </init-param>
</filter>
<filter-mapping>
  <filter-name>CorsFilter</filter-name>
  <url-pattern>/*</url-pattern>
</filter-mapping>


```

#HQSE Installation

* Create database with the scripts located at folder HQSE_bd_sql 
* Publish HQSE war files at Apache Tomcat webapps folder
* Publish HQSE Web Configuration at Apache Tomcat webapps folder or at any web server
* Publish HQSE Web Tester at Apache Tomcat webapps folder or at any web server


#Running
* Check software base applications are running, postgresql and apache tomcat

#API Overview
For a detailed description of the Restfull API services defined at HQSE read the [User and Programmer Guide][hqse5] 

#Testing
* At folder HQSE_curl_Tester are included a set of curl commands to test the Web Services of HQSE. Open command console and exec the sh files in the supplied order.
* At HQSE Web Tester : Define the testing required values and check with the user interface the main methods to GET and POST a questionnaire

#Build and Install 
* Web Services are provided as java maven projects, install any Java IDE (Eclipse Luna used for first realease)
* Import the maven projects provided at folder HQSE_WebServices_Code_BETA  in your own workspace
* At commons.mng project select option Menu "Run as/Maven clean" and  "Run as/Maven install" 
* At questionnaire.mng project select option Menu "Run as/Maven clean" and  "Run as/Maven install" 
* Or run maven commands from console


#License

Health Questionnaire SE is licensed under Affero General Public License (GPL) version 3.

[hqse1]:https://www.fi-star.eu
[hqse2]:http://catalogue.fi-star.eu/enablers/health-questionnaire-service

[hqse3]: https://wiki.postgresql.org/wiki/Detailed_installation_guides
[hqse4]: https://tomcat.apache.org/tomcat-7.0-doc/appdev/installation.html

[hqse5]: http://catalogue.fi-star.eu/sites/default/files/enabler-atttachments/Health%20Questionnaire%20SE%20%20User%20and%20Programmer%20Guide%20Beta.pdf 
