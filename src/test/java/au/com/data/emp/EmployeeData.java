package au.com.data.emp;

import lombok.Builder;
import lombok.Getter;
@Getter
@Builder
public class EmployeeData {
    private String       firstname;
    private String       lastname;
    private String       startDate;
    private String       dateOfBirth;
    private String       department;
    private String       jobTitle;
    private String       email;
    private String       mobile;
    private String       address;
    private int          baseSalary;
}