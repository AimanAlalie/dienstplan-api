package de.alalie.dienstplanapi.employee;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService service;
    private final EmployeeMapper mapper;


    public EmployeeController(EmployeeService service, EmployeeMapper mapper) {
        this.service = service;
        this.mapper = mapper;

    }


    @GetMapping
    public List<EmployeeResponse> findAll() {
        return service.findAll()
                .stream()
                .map(e -> mapper.toResponse(e))
                .toList();
    }


    @GetMapping("/{id}")
    public EmployeeResponse findById(@PathVariable UUID id) {
        Employee employee = service.findById(id);
        return mapper.toResponse(employee);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeResponse create(@Valid @RequestBody EmployeeRequest request) {
        Employee saved = service.create(mapper.toEntity(request));
        return mapper.toResponse(saved);
    }


}

