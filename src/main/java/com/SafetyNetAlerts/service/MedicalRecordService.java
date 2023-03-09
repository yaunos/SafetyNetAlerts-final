package com.SafetyNetAlerts.service;

import com.SafetyNetAlerts.model.MedicalRecord;

import java.util.List;

public interface MedicalRecordService {
    List<MedicalRecord> getMedicalRecords();

    List<MedicalRecord> findMedicalRecordsByFirstNameAndLastName(String firstName, String lastName);

    List<MedicalRecord> getMedicalRecordsByAgeRange(int MinAge, int MaxAge);

    void addMedicalRecordInDataSource(MedicalRecord medicalRecord);

    void updateMedicalRecordInDataSource(MedicalRecord medicalRecord, String firstName, String lastName);

    void deleteMedicalRecordInDataSource(String firstName, String lastName);
}