package de.alalie.dienstplanapi.employee;

import de.alalie.dienstplanapi.common.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock
    EmployeeRepository repository;// Database
    @InjectMocks
    EmployeeService service;


    @Test
    void findById_returnsEmployee_whenExists() {
        // Given
        UUID id = UUID.randomUUID();
        Employee employee = new Employee();
        employee.setFirstName("Aiman");
        when(repository.findById(id)).thenReturn(Optional.of(employee));

        // When
        Employee result = service.findById(id);

        // Then
        assertThat(result.getFirstName()).isEqualTo("Aiman");
    }

    @Test
    void create_savesAndReturnsEmployee() {
        Employee employee = new Employee();
        employee.setFirstName("Aiman");
        when(repository.save(employee)).thenReturn(employee);

        Employee result = service.create(employee);
        assertThat(result).isSameAs(employee);
        verify(repository).save(employee);
    }

    @Test
    void findById_throwsException_whenNotFound() {
        UUID id = UUID.randomUUID();

        when(repository.findById(id))
                .thenReturn(Optional.empty());

        assertThatThrownBy(() -> service.findById(id))
                .isInstanceOf(ResourceNotFoundException.class);
    }
}