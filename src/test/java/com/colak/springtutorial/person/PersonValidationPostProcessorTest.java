package com.colak.springtutorial.person;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootTest
class PersonValidationPostProcessorTest {

    @TestConfiguration
    public class PersonConfig {

        // This will cause .BeanCreationException
        @Bean
        public Person getInstance() {
            return new Person("Person", 111);
        }
    }

    @Test
    void testPerson () {
    }
}
