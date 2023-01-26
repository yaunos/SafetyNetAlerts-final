package com.SafetyNetAlerts.service.Impl;

import com.SafetyNetAlerts.model.Firestation;
import com.SafetyNetAlerts.model.GlobalData;
import com.SafetyNetAlerts.model.MedicalRecord;
import com.SafetyNetAlerts.model.Person;
import com.SafetyNetAlerts.repository.GlobalDataRepository;
import com.SafetyNetAlerts.service.GlobalDataAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GlobalDataAppServiceImpl implements GlobalDataAppService {

    @Autowired
    private GlobalDataRepository globalDataRepository;

    public GlobalData readDataFromJson() {
        return null;
    }

    @Override
    public void writeDataInJson(GlobalDataAppService globalDataAppService) {

    }

    @Override
    public void addPersonInJson(Person personToAdd) {

    }

    @Override
    public void updatePersonInJson(Person personToUpdateValue) {

    }

    @Override
    public void deletePersonInJson(Person personToDelete) {

    }

    @Override
    public void addFirestationInJson(Firestation firestationToAdd) {

    }

    @Override
    public void updateFirestationInJson(Firestation firestationToUpdateValue) {

    }

    @Override
    public void deleteFirestationInJson(String address) {

    }

    @Override
    public void addMedicalRecordInJson(MedicalRecord medicalRecordToAdd) {

    }

    @Override
    public void updateMedicalRecordInJson(MedicalRecord medicalRecordToUpdateValue) {

    }

    @Override
    public void deleteMedicalRecordInJson(String firstName, String lastName) {

    }


}