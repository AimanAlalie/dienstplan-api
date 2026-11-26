package de.alalie.dienstplanapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class DienstplanApiApplicationTests {

    @Test
    void contextLoads() {
    }

}
