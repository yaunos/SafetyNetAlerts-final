package com.SafetyNetAlerts.repository;

import com.SafetyNetAlerts.model.Firestation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest

public class FirestationRepositoryTest {


        @Autowired
        private FirestationRepository firestationRepository;

        public static List<Firestation> allFirestations;

        @BeforeAll
        public void setUp() {
            allFirestations = firestationRepository.getFirestationsFromGlobalData();
        }

        @Test
        public void getFirestationsFromGlobalDataTest() {
            String address0 = allFirestations.get(0).getAddress();
            Long station1 = allFirestations.get(1).getStation();

            assertEquals("1509 Culver St", address0);
            assertEquals(2, station1);
        }

        /*
        @Test
        public void getFirestationByAddressTest() {
            List<Firestation> foundFirestations = firestationRepository.getFirestationsByAddressLocation(allFirestations, "748 Townings Dr");

            String address = foundFirestations.get(0).getAddress();
            Long station = foundFirestations.get(0).getStation();

            assertEquals("748 Townings Dr", address);
            assertEquals(3, station);
        }

        @Test
        public void getFirestationsByStationTest() {
            List<Firestation> foundFirestations = firestationRepository.getFirestationsByStation( allFirestations, (2));

            Long station0 = foundFirestations.get(0).getStation();
            String address0 = foundFirestations.get(0).getAddress();
            String address1 = foundFirestations.get(1).getAddress();
            String address2 = foundFirestations.get(2).getAddress();

            assertEquals(2, station0);
            assertEquals("29 15th St", address0);
            assertEquals("892 Downing Ct", address1);
            assertEquals("951 LoneTree Rd", address2);

        }

         */
}

