# api_automation_crudemp

## Project Description:
* API Testing Automation framework - Rest-assured, CRUD operations of an Employee api. 
* Written in Java with TestNG, RestAssured & Maven
* Can run test scripts in parallel

## Setup:
* Install Java 17
* Install Maven

## Run tests: 
* To execute the tests, run below command 
* mvn clean verify

## To Generate Report:
* To generate report for the test run status, run below command
* mvn allure:report

## Tools Used:
Hamcrest Matchers are used for assertions.
TestNG Listeners are used to capture the events in logs.
Log4j is used to capture logs.
FAKE Rest APIs on Reqres.in is used for testing.
End to End scenarios have been added for the employee API endpoints.

## Sample Report below:
<img width="1680" alt="Screen Shot 2023-08-31 at 4 33 30 pm" src="https://github.com/JammulaMalleswari/api_automation_crudemp/assets/117786488/973c0e21-fd20-49e7-b3c1-0cdc21f7eeeb">
<img width="1679" alt="Screen Shot 2023-08-31 at 4 33 22 pm" src="https://github.com/JammulaMalleswari/api_automation_crudemp/assets/117786488/d478a8b2-8855-4ffa-99c7-614730204d1e">

