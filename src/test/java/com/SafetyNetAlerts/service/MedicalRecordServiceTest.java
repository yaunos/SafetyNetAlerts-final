package com.SafetyNetAlerts.service;

import com.SafetyNetAlerts.TestUtils;
import com.SafetyNetAlerts.model.GlobalData;
import com.SafetyNetAlerts.model.MedicalRecord;
import com.SafetyNetAlerts.repository.MedicalRecordRepository;
import com.SafetyNetAlerts.repository.PersonRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.text.SimpleDateFormat;
import java.util.List;

@SpringBootTest
public class MedicalRecordServiceTest {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Autowired
    private MedicalRecordService medicalRecordService;

    @MockBean
    private PersonRepository personRepository;

    @MockBean
    private MedicalRecordRepository medicalRecordRepository;

    @BeforeEach
    public void beforeEach(){
        GlobalData globalData = TestUtils.initDatas();
        Mockito.when(medicalRecordRepository.getMedicalRecordsFromDataSource()).thenReturn(globalData.getMedicalrecords());
        Mockito.when(medicalRecordRepository.getMedicalRecordsFromFirstNameAndLastName("Ali", "Baba")).thenReturn(globalData.getMedicalrecords().subList(0,0));
    }

    @Test
    public void getMedicalRecords(){

        List<MedicalRecord> results = medicalRecordService.getMedicalRecords();

        Assert.assertNotNull(results);
        Assert.assertEquals(3, results.size());

    }

    /*
    @Test
    public void testDeleteMedicalRecords() {
        MedicalRecord medicalRecord = new MedicalRecord();
        List<String> allergies = new ArrayList();
        List<String> medications = new ArrayList();
        try {
            medicalRecord.setBirthdate(sdf.parse("01/01/2001"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        allergies.add("shellfish");
        medications.add("hydrapermazol:300mg");
        medications.add("dodoxadin:30mg");

        medicalRecord.setMedications(medications);
        medicalRecord.setAllergies(allergies);
        medicalRecordService.addMedicalRecordInDataSource(medicalRecord);

        List<MedicalRecord> results = medicalRecordService.getMedicalRecords();

        Assert.assertNotNull(results);
        Assert.assertEquals(4, results.size());

    }
    */

}
