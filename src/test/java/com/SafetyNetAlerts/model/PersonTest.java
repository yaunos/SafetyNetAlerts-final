package com.SafetyNetAlerts.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

    @SpringBootTest
    public class PersonTest {

        @Test
        public void PersonSetAndGetTest() {

            Person personTest = new Person();

            personTest.setFirstName("Jean");
            personTest.setLastName("TILLET");
            personTest.setAddress("rue ronde");
            personTest.setZip(30000);
            personTest.setCity("Viville");
            personTest.setPhone("888-333-5555");
            personTest.setEmail("jeantillet@courrier.fr");

            assertEquals("Jean", personTest.getFirstName());
            assertEquals("TILLET", personTest.getLastName());
            assertEquals("rue ronde", personTest.getAddress());
            assertEquals(30000, personTest.getZip());
            assertEquals("Viville", personTest.getCity());
            assertEquals("888-333-5555", personTest.getPhone());
            assertEquals("jeantillet@courrier.fr", personTest.getEmail());
        }

    }
