package de.alalie.dienstplanapi.employee;

import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public Employee toEntity(EmployeeRequest request) {
        Employee employee = new Employee();
        employee.setEmployeeNumber(request.employeeNumber());
        employee.setFirstName(request.firstName());
        employee.setLastName(request.lastName());
        employee.setAbbreviation(request.abbreviation());
        employee.setPosition(request.position());
        employee.setDepartment(request.department());
        employee.setWeeklyHours(request.weeklyHours());
        employee.setPhone(request.phone());
        employee.setNotes(request.notes());
        employee.setHiredAt(request.hiredAt());

        if (request.color() != null) {
            employee.setColor(request.color());
        }
        if (request.employmentType() != null) {
            employee.setEmploymentType(request.employmentType());
        }
        if (request.status() != null) {
            employee.setStatus(request.status());
        }
        return employee;
    }

    public EmployeeResponse toResponse(Employee employee) {
        return new EmployeeResponse(
                employee.getId(),
                employee.getEmployeeNumber(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getAbbreviation(),
                employee.getColor(),
                employee.getPosition(),
                employee.getDepartment(),
                employee.getEmploymentType(),
                employee.getWeeklyHours(),
                employee.getPhone(),
                employee.getStatus(),
                employee.getNotes(),
                employee.getHiredAt(),
                employee.getCreatedAt(),
                employee.getUpdatedAt()
        );
    }
}