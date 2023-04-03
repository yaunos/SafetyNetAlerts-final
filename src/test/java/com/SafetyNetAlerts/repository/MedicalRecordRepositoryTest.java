package com.SafetyNetAlerts.repository;

import com.SafetyNetAlerts.TestUtils;
import com.SafetyNetAlerts.model.GlobalData;
import com.SafetyNetAlerts.model.MedicalRecord;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
public class MedicalRecordRepositoryTest {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @MockBean
    private GlobalDataRepository globalDataRepository;

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    @BeforeEach()
    public void beforeEach(){
        GlobalData global = TestUtils.initDatas();
        Mockito.when(globalDataRepository.read()).thenReturn(global);
    }

    @Test
    public void getMedicalRecordsByFirstNameAndLastNameTest() {
        List<MedicalRecord> results = medicalRecordRepository.getMedicalRecordsFromFirstNameAndLastName("Ali", "Baba");

        Assert.assertNotNull(results);
        Assert.assertEquals(results.size(), 1);
        MedicalRecord medicalRecord = results.get(0);
        Assert.assertEquals("Ali", medicalRecord.getFirstName());
        Assert.assertEquals("Baba", medicalRecord.getLastName());

    }
/*
    @Test
    public void getMedicalRecordsUnderSpecificAgeTest() {
        List<MedicalRecord> records = medicalRecordRepository.getMedicalRecordsFromDataSource();
        List<MedicalRecord> results = medicalRecordRepository.getMedicalRecordsUnderASpecificAge(records,18);

        assertNotNull(results);
        Assert.assertEquals(results.size(), 1);
    }
    */



    @Test
    public void getMedicalRecordsTest() {
        List<MedicalRecord> results = medicalRecordRepository.getMedicalRecordsFromDataSource();

        Assert.assertNotNull(results);
        Assert.assertEquals(results.size(), 3);

    }

    @Test
    public void addMedicalRecordTest() {

        MedicalRecord mc4 = new MedicalRecord();
        List<String> allergies = new ArrayList();
        List<String> medications = new ArrayList();
        allergies.add("shellfish");
        medications.add("hydrapermazol:300mg");
        medications.add("dodoxadin:30mg");

        mc4.setFirstName("Lilian");
        mc4.setLastName("Pagrand");

        try {
            mc4.setBirthdate(sdf.parse("01/01/2001"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        allergies.add("shellfish");
        medications.add("hydrapermazol:300mg");
        medications.add("dodoxadin:30mg");

        mc4.setMedications(medications);
        mc4.setAllergies(allergies);
        medicalRecordRepository.addMedicalRecordInDataSource(mc4);

        List<MedicalRecord> medicalRecords = medicalRecordRepository.getMedicalRecordsFromDataSource();

        Assert.assertNotNull(medicalRecords);
        Assert.assertEquals(4, medicalRecords.size());
        MedicalRecord medicalRecord = medicalRecords.get(3);
        Assert.assertEquals("Pagrand", medicalRecord.getLastName());

    }

    @Test
    public void updateMedicalRecordTest() {
        MedicalRecord newMedicalRecord = new MedicalRecord();
        try {
        List<String> allergies = new ArrayList();
        List<String> medications = new ArrayList();
        allergies.add("pollen");
        medications.add("tic:20mg");
        medications.add("tac:100mg");

        newMedicalRecord.setFirstName("Ali");
        newMedicalRecord.setLastName("Baba");
        newMedicalRecord.setBirthdate(sdf.parse("01/01/2001"));
        //newMedicalRecord.allergies.add("pollen");
        newMedicalRecord.setAllergies(allergies);
        newMedicalRecord.setMedications(medications);
        medicalRecordRepository.updateMedicalRecordInDataSource(newMedicalRecord, "Ali", "Baba");

        List<MedicalRecord> medicalRecord = medicalRecordRepository.getMedicalRecordsFromFirstNameAndLastName("Ali", "Baba");

        Assert.assertNotNull(medicalRecord);
        Assert.assertEquals(sdf.parse("01/01/2001"), medicalRecord.get(0).getBirthdate());
        } catch (ParseException e) {
        throw new RuntimeException(e);
        }
    }
    @Test
    public void deleteMedicalRecordTest() {

        medicalRecordRepository.deleteMedicalRecordInDataSource("Ali", "Baba");
        List<MedicalRecord> medicalRecords = medicalRecordRepository.getMedicalRecordsFromDataSource();

        Assert.assertNotNull(medicalRecords);
        Assert.assertEquals(2, medicalRecords.size());

    }
}

