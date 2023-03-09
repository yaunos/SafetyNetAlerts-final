package com.SafetyNetAlerts.model;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FirestationTest {

    @Test
    public void FirestationSetAndGetTest() {

        Firestation firestationTest = new Firestation();

        firestationTest.setAddress("First Avenue");
        firestationTest.setStation(44);

        assertEquals("First Avenue", firestationTest.getAddress());
        assertEquals(44, firestationTest.getStation());
    }


}
