package com.SafetyNetAlerts.model;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MedicalRecordTest {
    @Test
    public void MedicalRecordSetandGetTest() {

        MedicalRecord medicalRecordTest = new MedicalRecord();
        List<String> medications = List.of(new String[]{"dubidon:20mg", "tretrecool:400mg"});
        List<String> allergies=List.of(new String[]{"papaya"});
        Date dateTest = new Date();

        medicalRecordTest.setFirstName("Jo");
        medicalRecordTest.setLastName("NATHAN");
        medicalRecordTest.setBirthdate(dateTest);
        medicalRecordTest.setMedications(medications);
        medicalRecordTest.setAllergies(allergies);

        assertEquals("Jo", medicalRecordTest.getFirstName());
        assertEquals("NATHAN", medicalRecordTest.getLastName());
        assertEquals(dateTest, medicalRecordTest.getBirthdate());
        assertEquals(medications, medicalRecordTest.getMedications());
        assertEquals(allergies, medicalRecordTest.getAllergies());
    }

    @Test
    public void MedicalRecordOneRecordEqualsAnOtherRecordTest() {

        MedicalRecord medicalRecordTest = new MedicalRecord();
        MedicalRecord medicalRecordTest2 = new MedicalRecord();
        List<String> medications = List.of(new String[]{"dubidon:20mg", "tretrecool:400mg"});
        List<String> allergies=List.of(new String[]{"papaya"});
        Date dateTest = new Date();

        medicalRecordTest.setFirstName("Jo");
        medicalRecordTest.setLastName("NATHAN");
        medicalRecordTest.setBirthdate(dateTest);
        medicalRecordTest.setMedications(medications);
        medicalRecordTest.setAllergies(allergies);

        medicalRecordTest2.setFirstName("Jo");
        medicalRecordTest2.setLastName("NATHAN");
        medicalRecordTest2.setBirthdate(dateTest);
        medicalRecordTest2.setMedications(medications);
        medicalRecordTest2.setAllergies(allergies);

        assertTrue(medicalRecordTest.equals(medicalRecordTest2));

    }

    @Test
    public void MedicalRecordOneRecordDoesntEqualAnOtherRecordTest() {

        MedicalRecord medicalRecordTest = new MedicalRecord();
        MedicalRecord medicalRecordTest2 = new MedicalRecord();
        List<String> medications = List.of(new String[]{"dubidon:20mg", "tretrecool:400mg"});
        List<String> allergies=List.of(new String[]{"papaya"});
        Date dateTest = new Date();

        medicalRecordTest.setFirstName("Jo");
        medicalRecordTest.setLastName("NATHAN");
        medicalRecordTest.setBirthdate(dateTest);
        medicalRecordTest.setMedications(medications);
        medicalRecordTest.setAllergies(allergies);

        medicalRecordTest2.setFirstName("Jojo");
        medicalRecordTest2.setLastName("NATHAN");
        medicalRecordTest2.setBirthdate(dateTest);
        medicalRecordTest2.setMedications(medications);
        medicalRecordTest2.setAllergies(allergies);

        assertFalse(medicalRecordTest.equals(medicalRecordTest2));

    }

    @Test
    public void MedicalRecordToStringTest() {

        MedicalRecord medicalRecordTest = new MedicalRecord();
        String medicalRecordTestString = "MedicalRecord(firstName=prenom, lastName=nom, birthdate=Wed Sep 08 00:00:00 CEST 2010, medications=[dubidon:20mg, tretrecool:400mg], allergies=[papaya])";
        String[] medications= {"dubidon:20mg", "tretrecool:400mg"};
        String[] allergies= {"papaya"};

        Date dateTest = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dateString = "08/09/2010";
        try {
            dateTest = simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        medicalRecordTest.setFirstName("prenom");
        medicalRecordTest.setLastName("nom");
        medicalRecordTest.setBirthdate(dateTest);
        medicalRecordTest.setMedications(List.of(medications));
        medicalRecordTest.setAllergies(List.of(allergies));

        assertEquals(medicalRecordTestString, medicalRecordTest.toString());
    }


    @Test
    public void MedicalRecordHashCodeTest() {

        MedicalRecord medicalRecordTest = new MedicalRecord();;
        int code = medicalRecordTest.hashCode();

        assertNotEquals(0, code);

    }


}
