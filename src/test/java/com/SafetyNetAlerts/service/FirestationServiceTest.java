package com.SafetyNetAlerts.service;

import com.SafetyNetAlerts.TestUtils;
import com.SafetyNetAlerts.model.Firestation;
import com.SafetyNetAlerts.model.GlobalData;
import com.SafetyNetAlerts.repository.FirestationRepository;
import com.SafetyNetAlerts.repository.PersonRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
public class FirestationServiceTest {

    @Autowired
    private FirestationService firestationService;

    @MockBean
    private PersonRepository personRepository;

    @MockBean
    private FirestationRepository firestationRepository;

    @BeforeEach
    public void beforeEach(){
        GlobalData globalData = TestUtils.initDatas();
        Mockito.when(firestationRepository.getFirestationsFromGlobalData()).thenReturn(globalData.getFirestations());
        Mockito.when(firestationRepository.getAdressesByStationNumber(1)).thenReturn(globalData.getFirestations()
                .subList(0,0)
                .stream()
                .map(station->station.getAddress())
                .collect(Collectors.toList()));
    }

    @Test
    public void testGetFirestations() {

        List<Firestation> results = firestationService.getFirestations();

        Assert.assertNotNull(results);
        Assert.assertEquals(3, results.size());

    }

    /*
    @Test
    public void testAddFirestations() {
        Firestation firestation = new Firestation();
        firestation.setAddress("1 addresse DepluspourcetteStation");
        firestation.setStation(4);
        firestationService.addFirestationIntoDataSource(firestation);

        List<Firestation> results = firestationService.getFirestations();

        Assert.assertNotNull(results);
        Assert.assertEquals(4, results.size());

    }
    */


}
