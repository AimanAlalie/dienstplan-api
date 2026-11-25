package de.alalie.dienstplanapi;

import de.alalie.dienstplanapi.employee.Employee;
import de.alalie.dienstplanapi.employee.EmployeeRepository;
import de.alalie.dienstplanapi.employee.EmployeeStatus;
import de.alalie.dienstplanapi.employee.EmploymentType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Instant;

@SpringBootApplication
public class DienstplanApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DienstplanApiApplication.class, args);

    }

}
