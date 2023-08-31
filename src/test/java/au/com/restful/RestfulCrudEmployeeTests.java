package au.com.restful;

import au.com.data.emp.EmployeeData;
import com.opencsv.exceptions.CsvException;
import io.qameta.allure.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static au.com.data.emp.EmployeeDataBuilder.getEmployeeData;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class RestfulCrudEmployeeTests extends BaseSetup {

    private EmployeeData newEmployee;
    private String employeeId;
    public String path = "src/test/resources/testData/empData.csv";


    @BeforeTest
    public void testSetup() throws URISyntaxException, IOException, CsvException {
        newEmployee = getEmployeeData(path);
    }

    @Test(priority = 0)
    @Description("Creating new Employee Record - Post request")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Employee tests using rest-assured")
    @Step("Create new employee record")
    public void createEmployeeTest() {
        employeeId = given().body(newEmployee)
                .when()
                .post("/Employee")
                .then()
                .statusCode(201)
                .and()
                .assertThat()
                .body("firstname", equalTo(newEmployee.getFirstname()), "lastname",
                        equalTo(newEmployee.getLastname()), "dateOfBirth", equalTo(newEmployee.getDateOfBirth()),
                        "startDate", equalTo(newEmployee.getStartDate()), "baseSalary", equalTo(newEmployee.getBaseSalary()),
                        "department", equalTo(newEmployee.getDepartment()), "jobTitle", equalTo(newEmployee.getJobTitle()),
                        "email", equalTo(newEmployee.getEmail()),  "mobile", equalTo(newEmployee.getMobile()),
                        "address", equalTo(newEmployee.getAddress()))
                .extract()
                .path("_id");
    }

    @Test (priority = 1)
    @Description("Retrieving an employee record - Get request")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Employee tests using rest-assured")
    @Step("Get the newly created employee record")
    public void getEmployeeTest() {
        given().get("/Employee/" + employeeId)
                .then()
                .statusCode(200)
                .and()
                .assertThat()
                .body("firstname", equalTo(newEmployee.getFirstname()), "lastname",
                        equalTo(newEmployee.getLastname()), "dateOfBirth", equalTo(newEmployee.getDateOfBirth()),
                        "startDate", equalTo(newEmployee.getStartDate()), "baseSalary", equalTo(newEmployee.getBaseSalary()),
                        "department", equalTo(newEmployee.getDepartment()), "jobTitle", equalTo(newEmployee.getJobTitle()),
                        "email", equalTo(newEmployee.getEmail()),  "mobile", equalTo(newEmployee.getMobile()),
                        "address", equalTo(newEmployee.getAddress()));
    }

    @Test (priority = 2)
    @Description("Updating an employee record - Put request")
    @Severity(SeverityLevel.NORMAL)
    @Story("Employee tests using rest-assured")
    @Step("Update the employee record")
    public void updateEmployeeTest() throws URISyntaxException, IOException, CsvException {
        EmployeeData updatedBooking = getEmployeeData(path);
        given().body(updatedBooking)
                .when()
                .put("/Employee/" + employeeId)
                .then()
                .statusCode(200)
                .and()
                .assertThat()
                .extract();
    }

    @Test (priority = 3)
    @Description("Deleting an employee record - Delete request")
    @Severity(SeverityLevel.NORMAL)
    @Story("Employee tests using rest-assured")
    @Step("Delete the employee record")
    public void deleteEmployeeTest() {
        given().when()
                .delete("/Employee/" + employeeId)
                .then()
                .statusCode(200);
    }

    @Test (priority = 4)
    @Description("Checking if employee record is deleted by retrieving a deleted booking - Get request")
    @Severity(SeverityLevel.NORMAL)
    @Story("Employee tests using rest-assured")
    @Step("Check by retrieving deleted booking")
    public void checkEmployeeIsDeleted() {
        given().get("/Employee/" + employeeId)
                .then()
                .statusCode(404);
    }

}
