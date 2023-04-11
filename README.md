# Description :
This Java application is an API Rest application coded in an MVC way

This application consists in reading a data.json ressource file in resources/data.json,
interrogating this file with parameters filters,
then returning in a browser some json data outputs to be used by emergency team members 


# Development environment installation Prerequisites :

Whether you are using Eclipse or IntelliJ :

* Install Java for Eclipse :
https://adoptium.net/temurin/

OR

* install Java for IntelliJ :

Download and Install IntelliJ.
Download and Install Java 8 SDK.
...
Set up IntelliJ
Choose Configure > Project Defaults > Project Structure > JDK.

Select the appropriate Java JDK folder. PC: C:\Program Files\Java\jdk1.8.x. ...
Click Apply.

* Install Maven
https://maven.apache.orgg/install.htm

* Install springBoot
For Eclipse :
https://spring.io/tools

* Setup SpringBoot for IntelliJ
https://start.spring.io/


# Cleaning the code, testing the application :

mvn clean install -U 

# Running the server

.\mvnw spring-boot:run

# API URI Endpoints :

## GET method : Read the Json file and return Json data

URL1 EndPoint list of persons covered by a station
http://localhost:8080/firestation?station_number=<number>

URL 2 Endpoint childAlert
http://localhost:8080/childAlert?address=<address>

URL3 Endpoint phoneAlert
http://localhost:8080/phoneAlert?firestation=<number>

URL4 Endpoint list of inhabitants by station address
http://localhost:8080/fire?address=<address>

URL5 Endpoint list of households from list
http://localhost:8080/flood/stations?stations=<list of station_numbers>

URL6 Endpoint list of inhabitants with medical records http://localhost:8080/personInfo?firstName=<firstName>&lastName=<lastName>

URL7 Endpoint list of emails
http://localhost:8080/communityEmail?city=<city>


# POST, PUT, DELETE methods : add, update, delete Json data in the Json file

http://localhost:8080/person

http://localhost:8080/firestation

http://localhost:8080/medicalRecord






