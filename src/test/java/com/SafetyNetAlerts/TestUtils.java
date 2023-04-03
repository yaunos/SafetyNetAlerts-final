package com.SafetyNetAlerts;

import com.SafetyNetAlerts.model.Firestation;
import com.SafetyNetAlerts.model.GlobalData;
import com.SafetyNetAlerts.model.MedicalRecord;
import com.SafetyNetAlerts.model.Person;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TestUtils {

    public static GlobalData initDatas(){
        try {
            GlobalData output = new GlobalData();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            List<Person> persons = new ArrayList<>();
            List<Firestation> firestations = new ArrayList<>();
            List<MedicalRecord> medicalRecords = new ArrayList<>();


            Person p1 = new Person();
            p1.setAddress("31 rue Maplace");
            p1.setCity("Yaoundé");
            p1.setEmail("toto@free.fr");
            p1.setPhone("076059820");
            p1.setZip("30000");
            p1.setFirstName("Ali");
            p1.setLastName("Baba");

            Person p2 = new Person();
            p2.setAddress("32 rue Taplace");
            p2.setCity("Lyon");
            p2.setEmail("toto1@free.fr");
            p2.setPhone("076059822");
            p2.setZip("30000");
            p2.setFirstName("Hervé");
            p2.setLastName("Renard");

            Person p3 = new Person();
            p3.setAddress("33 rue Saplace");
            p3.setCity("Valence");
            p3.setEmail("toto3@free.fr");
            p3.setPhone("0711121314");
            p3.setZip("30000");
            p3.setFirstName("Didier");
            p3.setLastName("Delaville");

            persons.add(p1);
            persons.add(p2);
            persons.add(p3);

            output.setPersons(persons);

            Firestation f1 = new Firestation();
            f1.setAddress("30 rue Maplace");
            f1.setStation(1);

            Firestation f2 = new Firestation();
            f2.setAddress("32 rue Taplace");
            f2.setStation(2);

            Firestation f3 = new Firestation();
            f3.setAddress("33 rue Saplace");
            f3.setStation(3);

            firestations.add(f1);
            firestations.add(f2);
            firestations.add(f3);

            output.setFirestations(firestations);

            List<String> allergies = new ArrayList();
            List<String> medications = new ArrayList();
            allergies.add("shellfish");
            medications.add("hydrapermazol:300mg");
            medications.add("dodoxadin:30mg");

            MedicalRecord mc1 = new MedicalRecord();
            mc1.setFirstName("Ali");
            mc1.setLastName("Baba");
            mc1.setBirthdate(sdf.parse("01/12/1890"));
            mc1.setAllergies(allergies);
            mc1.setMedications(medications);

            MedicalRecord mc2 = new MedicalRecord();
            mc2.setFirstName("Hervé");
            mc2.setLastName("Renard");
            mc2.setBirthdate(sdf.parse("09/01/2013"));
            mc2.setAllergies(allergies);
            mc2.setMedications(medications);

            MedicalRecord mc3 = new MedicalRecord();
            mc3.setFirstName("Didier");
            mc3.setLastName("Delaville");
            mc3.setBirthdate(sdf.parse("07/12/1999"));
            mc3.setAllergies(allergies);
            mc3.setMedications(medications);

            medicalRecords.add(mc1);
            medicalRecords.add(mc2);
            medicalRecords.add(mc3);

            output.setMedicalrecords(medicalRecords);

            return output;

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


    }

}
