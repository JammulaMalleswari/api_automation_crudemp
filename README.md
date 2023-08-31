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
![](/Users/jammula/Desktop/Screen Shot 2023-08-31 at 4.33.30 pm.png)
![](/Users/jammula/Desktop/Screen Shot 2023-08-31 at 4.33.22 pm.png)