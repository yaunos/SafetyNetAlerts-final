package com.SafetyNetAlerts.service;

import com.SafetyNetAlerts.model.MedicalRecord;

import java.util.List;

public interface MedicalRecordService {
    List<MedicalRecord> getMedicalRecords();

    List<MedicalRecord> getMedicalRecordsByFirstNameAndLastName(String firstName, String lastName);

    List<MedicalRecord> getMedicalRecordsByAgeRange(int MinAge, int MaxAge);

    void addMedicalRecordIntoDataSource(MedicalRecord medicalRecord);

    void updateMedicalRecordIntoDataSource(MedicalRecord medicalRecord);

    void deleteMedicalRecordIntoDataSource(String firstName, String lastName);
}