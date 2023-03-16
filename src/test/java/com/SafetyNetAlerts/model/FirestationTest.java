package com.SafetyNetAlerts.model;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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


    @Test
    public void FirestationEqualsAnOtherFirestationTest() {

        Firestation firestationTest = new Firestation();
        Firestation firestationTest2 = new Firestation();

        firestationTest.setAddress("First Avenue");
        firestationTest.setStation(44);
        firestationTest2.setAddress("FirstAvenue");
        firestationTest2.setStation(44);

        assertEquals(true, firestationTest.equals(firestationTest2));
    }

    @Test
    public void TransformFirestationToStringTest() {

        Firestation firestationTest = new Firestation();
        String firestationTestString = "Firestation(address=New Street, station=6)";

        firestationTest.setAddress("New Street");
        firestationTest.setStation(6);

        assertEquals(firestationTestString, firestationTest.toString());
    }

    @Test
    public void FirestationHashCodeTest() {

        Firestation firestationTest = new Firestation();
        int code = firestationTest.hashCode();

        assertNotEquals(0, code);

    }
}
