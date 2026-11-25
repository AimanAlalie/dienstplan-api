package de.alalie.dienstplanapi.employee;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

public record EmployeeResponse(
        UUID id,
        String employeeNumber,
        String firstName,
        String lastName,
        String abbreviation,
        String color,
        String position,
        String department,
        EmploymentType employmentType,
        BigDecimal weeklyHours,
        String phone,
        EmployeeStatus status,
        String notes,
        LocalDate hiredAt,
        Instant createdAt,
        Instant updatedAt
) {
}