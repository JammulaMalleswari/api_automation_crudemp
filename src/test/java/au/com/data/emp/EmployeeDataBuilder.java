package au.com.data.emp;

import au.com.actions.ReadCSVFile;
import com.opencsv.exceptions.CsvException;
import net.datafaker.Faker;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class EmployeeDataBuilder {

    private static final Faker FAKER = new Faker ();
    public static EmployeeData getEmployeeData(String path) throws URISyntaxException, IOException, CsvException {
        SimpleDateFormat formatter = new SimpleDateFormat ("YYYY-MM-dd");
        String[] csvData = ReadCSVFile.cSVDataRead(path);
        return EmployeeData.builder ()
            .firstname (FAKER.name ()
                .firstName ())
            .lastname (FAKER.name ()
                .lastName ())
            .dateOfBirth (formatter.format (FAKER.date ()
                .birthday (25, 40)))
            .startDate (formatter.format (FAKER.date ()
                    .past (20, TimeUnit.DAYS)))
            .baseSalary (FAKER.number ()
                    .numberBetween (80000, 90000))
            .department (csvData[0])
            .jobTitle (csvData[1])
            .email (csvData[2])
            .mobile (csvData[3])
            .address (csvData[4])
            .build();
    }
}