package de.alalie.dienstplanapi.employee;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name ="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "employee_number")
    private String employeeNumber;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "abbreviation")
    private String abbreviation;
    @Column (name = "color")
    private String color;
    @Column(name = "position")
    private String position;
    @Column(name = "department")
    private String department;
    @Enumerated(EnumType.STRING)
    @Column(name = "employment_type")
    private EmploymentType employmentType;
    @Column(name = "weekly_hours")
    private BigDecimal weeklyHours;
    @Column(name = "phone")
    private String phone;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private EmployeeStatus status;
    @Column(name = "notes")
    private String notes;
    @Column(name = "hired_at")
    private LocalDate hiredAt;
    @Column(name = "created_at")
    private Instant createdAt;
    @Column(name = "updated_at")
    private Instant updatedAt;
}
