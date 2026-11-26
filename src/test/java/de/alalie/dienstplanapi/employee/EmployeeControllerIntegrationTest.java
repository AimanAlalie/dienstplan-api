package de.alalie.dienstplanapi.employee;

import de.alalie.dienstplanapi.TestcontainersConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Import(TestcontainersConfiguration.class)
class EmployeeControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void create_returns201_andSavedEmployee() throws Exception {
        String json = """
                {
                  "firstName": "Sara",
                  "lastName": "Müller",
                  "abbreviation": "SM"
                }
                """;

        mockMvc.perform(post("/api/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.firstName").value("Sara"))
                .andExpect(jsonPath("$.status").value("ACTIVE"));
    }

    @Test
    void create_returns400_whenFirstNameMissing() throws Exception {
        String json = """
                {
                  "lastName": "Müller",
                  "abbreviation": "SM"
                }
                """;

        mockMvc.perform(post("/api/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)).andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.detail").exists())
                .andExpect(jsonPath("$.errors").exists());

    }

    @Test
    void findById_returns404_whenNotFound() throws Exception {
        String json = """
                {
                  "lastName": "Müller",
                  "abbreviation": "SM"
                }
                """;

        mockMvc.perform(get("/api/employees/" + UUID.randomUUID()))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.detail")
                        .value(containsString("Employee not found")));
    }
}
