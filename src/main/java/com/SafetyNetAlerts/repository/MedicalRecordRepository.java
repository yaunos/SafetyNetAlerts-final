package com.SafetyNetAlerts.repository;

import com.SafetyNetAlerts.model.MedicalRecord;
import com.SafetyNetAlerts.model.Person;

import java.util.List;

public interface MedicalRecordRepository {

    List<MedicalRecord> getMedicalRecordsFromDataSource();

    List<MedicalRecord> getMedicalRecordsFromFirstNameAndLastName(String firstName, String lastName);

    List<MedicalRecord> getMedicalRecordsByAtLeastAge(List<MedicalRecord> medicalRecords, int minAge);

    List<MedicalRecord> getMedicalRecordsUnderASpecificAge(List<MedicalRecord> medicalRecords, int maxAge );


    void addMedicalRecordInDataSource(MedicalRecord medicalRecord);

    void updateMedicalRecordInDataSource(MedicalRecord medicalRecord);

    void deleteMedicalRecordInDataSource(String firstName, String LastName);


    int getAge(MedicalRecord medicalRecord);

    int countChildrenInAList(List<Person> persons, List<MedicalRecord> medicalRecords);
}

