package com.SafetyNetAlerts.repository;

import com.SafetyNetAlerts.TestUtils;
import com.SafetyNetAlerts.model.Firestation;
import com.SafetyNetAlerts.model.GlobalData;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

//@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest
//@RunWith(SpringRunner.class)
public class FirestationRepositoryTest {


        @Autowired
        private FirestationRepository firestationRepository;

        @MockBean
        private GlobalDataRepository globalDataRepository;

        public static List<Firestation> allFirestations;


        @BeforeEach()
        public void beforeEach(){
            GlobalData global = TestUtils.initDatas();
            Mockito.when(globalDataRepository.read()).thenReturn(global);
        }

        @Test
        public void getFirestationsByAddressTest(){
                List<String> results = firestationRepository.getAdressesByStationNumber(1);

                Assert.assertNotNull(results);
                Assert.assertEquals(results.size(), 1);
                String address = results.get(0);
                Assert.assertEquals("30 rue Maplace", address);
               // Assert.assertEquals("30 rue Maplace", firestation.getAddress());
               // Assert.assertEquals("", firestation.getStation());

        }

        @Test
        public void getFirestationsFromGlobalDataTest(){
                List<Firestation> results = firestationRepository.getFirestationsFromGlobalData();

                Assert.assertNotNull(results);
                Assert.assertEquals(results.size(), 3);
        }


        @Test
        public void deleteFireStationTest() {

                firestationRepository.deleteFirestationInDataSource(1L, "30 rue Maplace");
                List<Firestation> firestations = firestationRepository.getFirestationsFromGlobalData();

                Assert.assertNotNull(firestations);
                Assert.assertEquals(2, firestations.size());

        }

        @Test
        public void updateFirestationTest(){
                Firestation newFirestation = new Firestation();
                newFirestation.setStation(1L);
                newFirestation.setAddress("34 rue Maplace");
                firestationRepository.updateFirestationInDataSource(newFirestation, "30 rue Maplace", 1L);

                List<String> addresses = firestationRepository.getAdressesByStationNumber(1L);

                Assert.assertNotNull(addresses);
                Assert.assertEquals("34 rue Maplace", addresses.get(0));

        }

        @Test
        public void addFirestationTest(){
                Firestation newStation = new Firestation();
                newStation.setAddress("34 rue Maplace");
                newStation.setStation(4L);
                firestationRepository.addFirestationInDataSource(newStation);

                List<Firestation> stations = firestationRepository.getFirestationsFromGlobalData();

                Assert.assertNotNull(stations);
                Assert.assertEquals(4, stations.size());
        }



/*
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

