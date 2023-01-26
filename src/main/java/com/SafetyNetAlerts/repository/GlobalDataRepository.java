package com.SafetyNetAlerts.repository;

import com.SafetyNetAlerts.model.Firestation;
import com.SafetyNetAlerts.model.GlobalData;
import com.SafetyNetAlerts.model.MedicalRecord;
import com.SafetyNetAlerts.model.Person;

public interface GlobalDataRepository {

    public GlobalData read();

    public void write(GlobalData globalData);


    void addPerson(Person person);

    void updatePerson(Person person);

    void deletePerson(String firstName, String lastName);


    void addFirestation(Firestation firestation);

    void updateFirestation(Firestation firestation);

    void deleteFirestation(String address);

    void addMedicalRecord(MedicalRecord medicalRecord);

    void updateMedicalRecord(MedicalRecord medicalRecord);

    void deleteMedicalRecord(String firstName, String lastName);

}
