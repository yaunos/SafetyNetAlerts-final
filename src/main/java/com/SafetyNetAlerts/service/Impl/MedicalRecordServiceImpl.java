package com.SafetyNetAlerts.service.Impl;

import com.SafetyNetAlerts.model.MedicalRecord;
import com.SafetyNetAlerts.repository.GlobalDataRepository;
import com.SafetyNetAlerts.repository.MedicalRecordRepository;
import com.SafetyNetAlerts.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalRecordServiceImpl implements MedicalRecordService {

    @Autowired
    MedicalRecordRepository medicalRecordRepository;

    @Autowired
    GlobalDataRepository globalDataRepository;

    @Override
    public List<MedicalRecord> getMedicalRecords() {
        return medicalRecordRepository.getMedicalRecordsFromDataSource();
    }

    @Override
    public List<MedicalRecord> findMedicalRecordsByFirstNameAndLastName(String firstName, String lastName) {
        List<MedicalRecord> medicalRecords = globalDataRepository.read().getMedicalrecords();
        return medicalRecordRepository.getMedicalRecordsFromFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public List<MedicalRecord> getMedicalRecordsByAgeRange(int MinAge, int MaxAge) {
        List<MedicalRecord> medicalRecords = globalDataRepository.read().getMedicalrecords();
        return null;
    }

    @Override
    public void addMedicalRecordInDataSource(MedicalRecord medicalRecord) {
        medicalRecordRepository.addMedicalRecordInDataSource(medicalRecord);
    }

    @Override
    public void updateMedicalRecordInDataSource(MedicalRecord medicalRecord, String firstName, String lastName) {
        medicalRecordRepository.updateMedicalRecordInDataSource(medicalRecord, firstName, lastName);
    }

    @Override
    public void deleteMedicalRecordInDataSource(String firstName, String lastName) {
        medicalRecordRepository.deleteMedicalRecordInDataSource(firstName, lastName);
    }
}
