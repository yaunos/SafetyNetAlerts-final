package com.SafetyNetAlerts.service;

import com.SafetyNetAlerts.model.Firestation;
import com.SafetyNetAlerts.model.GlobalData;
import com.SafetyNetAlerts.model.MedicalRecord;
import com.SafetyNetAlerts.model.Person;
import org.springframework.stereotype.Component;

@Component
public interface GlobalDataAppService {

    GlobalData readDataFromJson();

    void writeDataInJson(GlobalDataAppService globalDataAppService);


    void addPersonInJson(Person personToAdd);

    void updatePersonInJson(Person personToUpdateValue);

    void deletePersonInJson(Person personToDelete);


    void addFirestationInJson(Firestation firestationToAdd);

    void updateFirestationInJson(Firestation firestationToUpdateValue);

    void deleteFirestationInJson(String address);


    void addMedicalRecordInJson(MedicalRecord medicalRecordToAdd);

    void updateMedicalRecordInJson(MedicalRecord medicalRecordToUpdateValue);

    void deleteMedicalRecordInJson(String firstName, String lastName);

}
