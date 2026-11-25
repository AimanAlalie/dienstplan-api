package de.alalie.dienstplanapi.employee;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public record EmployeeRequest(
        @Size(max = 20) String employeeNumber,
        @NotBlank @Size(max = 100) String firstName,
        @NotBlank @Size(max = 100) String lastName,
        @NotBlank @Size(max = 5) String abbreviation,
        @Pattern(regexp = "^#[0-9a-fA-F]{6}$") String color,
        @Size(max = 100) String position,
        @Size(max = 100) String department,
        EmploymentType employmentType,
        @PositiveOrZero @Digits(integer = 2, fraction = 2) BigDecimal weeklyHours,
        @Size(max = 30) String phone,
        EmployeeStatus status,
        @Size(max = 1000) String notes,
        LocalDate hiredAt
) {
}