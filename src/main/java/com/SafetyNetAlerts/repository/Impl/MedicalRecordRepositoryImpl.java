package com.SafetyNetAlerts.repository.Impl;

import com.SafetyNetAlerts.model.GlobalData;
import com.SafetyNetAlerts.model.MedicalRecord;
import com.SafetyNetAlerts.model.Person;
import com.SafetyNetAlerts.repository.GlobalDataRepository;
import com.SafetyNetAlerts.repository.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class MedicalRecordRepositoryImpl implements MedicalRecordRepository {

    @Autowired
    private GlobalDataRepository globalDataRepository;

    @Override
    public List<MedicalRecord> getMedicalRecordsFromDataSource() {
        List<MedicalRecord> medicalRecordsList = new LinkedList<>();
        GlobalData datas = globalDataRepository.read();
        for (MedicalRecord m : datas.getMedicalrecords()) {
            medicalRecordsList.add(m);
        }
        return  medicalRecordsList;
    }

    @Override
    public List<MedicalRecord> getMedicalRecordsFromFirstNameAndLastName(String firstName, String lastName) {
        List<MedicalRecord> matchingMedicalRecordsList = new LinkedList<>();
        GlobalData datas = globalDataRepository.read();
        for (MedicalRecord m : datas.getMedicalrecords()) {
            if (m.getFirstName().equals(firstName) && m.getLastName().equals(lastName)) {
                matchingMedicalRecordsList.add(m);
            }
        }
        return matchingMedicalRecordsList;
    }

    @Override
    public List<MedicalRecord> getMedicalRecordsByAtLeastAge(List<MedicalRecord> medicalRecords, int minAge) {
        return null;
    }

    @Override
    public List<MedicalRecord> getMedicalRecordsUnderASpecificAge(List<MedicalRecord> medicalRecords, int maxAge) {
        return null;
    }

    @Override
    public void addMedicalRecordInDataSource(MedicalRecord medicalRecord) {
        //globalDataRepository.addMedicalRecord(medicalRecord);
        GlobalData global = globalDataRepository.read();
        global.getMedicalrecords().add(medicalRecord);
        globalDataRepository.write(global);

    }

    @Override
    public void updateMedicalRecordInDataSource(MedicalRecord medicalRecord, String firstName, String lastName) {
        //globalDataRepository.updateMedicalRecord(medicalRecord);
        GlobalData global = globalDataRepository.read();
        global.getMedicalrecords().forEach((medicalRecord1 -> {
            if(medicalRecord1.getFirstName().equals(firstName)&&medicalRecord1.getLastName().equals(lastName)) {
                medicalRecord1.setBirthdate(medicalRecord.getBirthdate());
                medicalRecord1.setMedications(medicalRecord.getMedications());
                medicalRecord1.setAllergies(medicalRecord.getAllergies());
            }
        }));
        globalDataRepository.write(global);
        //return medicalRecord;
    }

    @Override
    public void deleteMedicalRecordInDataSource(String firstName, String lastName) {
        GlobalData global = globalDataRepository.read();
        MedicalRecord medicalRecordToDelete = null;
        for (MedicalRecord medicalRecord : global.getMedicalrecords()) {
            //if (firstName.equals(medicalRecord.getFirstName())&& lastName.equals(medicalRecord.getLastName())) {
            if ((medicalRecord.getFirstName().equals(firstName))&&(medicalRecord.getLastName().equals(lastName))) {
                medicalRecordToDelete = medicalRecord;
            }
        }
        global.getMedicalrecords().remove(medicalRecordToDelete);
        globalDataRepository.write(global);
    }


    @Override
    public int getAge(MedicalRecord medicalRecord) {
        return 0;
    }

    @Override
    public int countChildrenInAList(List<Person> persons, List<MedicalRecord> medicalRecords) {
        return 0;
    }
}