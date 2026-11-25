package de.alalie.dienstplanapi.employee;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> findAll() {
        return repository.findAll();
    }

    public Employee findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found: " + id));
    }

    public Employee create(Employee employee) {
        return repository.save(employee);
    }
}
